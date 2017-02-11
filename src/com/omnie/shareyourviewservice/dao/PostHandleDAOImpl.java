package com.omnie.shareyourviewservice.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omnie.shareyourviewservice.hibermapping.Comment;
import com.omnie.shareyourviewservice.hibermapping.Post;
import com.omnie.shareyourviewservice.hibermapping.User;

@Repository
public class PostHandleDAOImpl implements PostHandleDAO {

	static Logger log = Logger.getLogger(PostHandleDAOImpl.class.getName());
	
	@Autowired
	protected SessionFactory syvsessionFactory;

	/**
	 * Get Current Session from Session Factory
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
		Transaction tx = getSession().beginTransaction();
		getSession().save(post);
		tx.commit();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pushUserCommentToPost(Comment comment) {
		Transaction tx = getSession().beginTransaction();
		getSession().save(comment);
		tx.commit();
	}

	@Override
	public List<Post> getAllPost() {
		Transaction tx = getSession().beginTransaction();
		@SuppressWarnings("unchecked")
		List<Post> postList =  getSession().createQuery("from com.omnie.shareyourviewservice.hibermapping.Post").list();
		log.info("postList!!! "+ postList);
		for(Post post : postList){
			log.info("post description!!! "+ post.getDescription());
		}
		getSession().close();
		tx.commit();
		// TODO Auto-generated method stub
		return postList;
	}

	@Override
	public List<Post> getAllPostByUser(String user_id) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from com.omnie.shareyourviewservice.hibermapping.Post where user_id =:user_id order by timestamp desc");
		List<Post> postList = query.setParameter("user_id", user_id).list() ;
		return postList;
	}

	@Override
	public Post getPostByPostId(Long postId) {
		
		Post post = (Post) getSession().get("com.omnie.shareyourviewservice.hibermapping.Post", postId);
		//Post post = query.setParameter("postid", postId). ;
		return post;
	}

	@Override
	public User getUser(String userid) {
		Query query = getSession().createQuery("from com.omnie.shareyourviewservice.hibermapping.User where user_id =:user_id");
		List<User> userList = query.setParameter("user_id", userid).list() ;
		// TODO Auto-generated method stub
		System.out.println("userList "+userList);
		return userList.size()>0?userList.get(0):null;
	}

}
