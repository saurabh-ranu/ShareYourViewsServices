package com.omnie.shareyourviewservice.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omnie.shareyourviewservice.hibermapping.Comment;
import com.omnie.shareyourviewservice.hibermapping.Post;
import com.omnie.shareyourviewservice.hibermapping.User;

@Transactional
@Repository
public class PostHandleDAOImpl implements PostHandleDAO {

	static Logger log = Logger.getLogger(PostHandleDAOImpl.class.getName());

	@Autowired
	protected SessionFactory syvsessionFactory;

	/**
	 * Get New Session from Session Factory
	 * 
	 * @return
	 */
	protected Session getSession() {
		return syvsessionFactory.openSession();
	}

	/**
	 * Save the User Post
	 */
	@Override
	public void pushUserPost(Post post) {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(post);
			tx.commit();

		} finally {
			if (null != session) {
				session.flush();
				session.close();
			}
		}

		// TODO Auto-generated method stub

	}

	@Override
	public void pushUserCommentToPost(Comment comment) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.save(comment);
		} finally {
			if (null != session) {
				session.flush();
				session.close();
			}
			if (null != tx) {
				tx.commit();
			}
		}
	}

	@Override
	public List<Post> getAllPost() {
		Transaction tx = null;
		Session session = getSession();

		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Post> postList = getSession().createQuery("from com.omnie.shareyourviewservice.hibermapping.Post")
					.list();
			log.info("postList!!! " + postList);
			for (Post post : postList) {
				log.info("post description!!! " + post.getDescription());
			}
			return postList;
		} finally {
			
			if (null != tx) {
				tx.commit();
			}
		}

		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPostByUser(String user_id) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSession();
			Query query = session.createQuery(
					"from com.omnie.shareyourviewservice.hibermapping.Post where user_id =:user_id order by timestamp desc");
			List<Post> postList = query.setParameter("user_id", user_id).list();
			return postList;
		} finally {

		}
	}

	@Override
	public Post getPostByPostId(Long postId) {
		Session session = null;
		try {
			session = getSession();
			Post post = (Post) session.get("com.omnie.shareyourviewservice.hibermapping.Post", postId);
			// Post post = query.setParameter("postid", postId). ;
			return post;
		} finally {
			if (null != session) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public User getUser(String userid) {
		Session session = null;
		List<User> userList = null;
		Transaction tx = null;
		try {
			session = getSession();
			Query query = session
					.createQuery("from com.omnie.shareyourviewservice.hibermapping.User where user_id =:user_id");
			userList = query.setParameter("user_id", userid).list();
			// TODO Auto-generated method stub
			System.out.println("userList " + userList);
				} finally {
			if (null != session) {
				session.close();
			}
		}
		return (null!=userList &&userList.size() > 0) ? userList.get(0) : null;
		
	}

}
