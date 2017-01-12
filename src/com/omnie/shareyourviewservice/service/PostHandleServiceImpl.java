/**
 * 
 */
package com.omnie.shareyourviewservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnie.shareyourviewservice.beans.CommentBean;
import com.omnie.shareyourviewservice.beans.PostBean;
import com.omnie.shareyourviewservice.beans.UserBean;
import com.omnie.shareyourviewservice.dao.PostHandleDAO;
import com.omnie.shareyourviewservice.hibermapping.Comment;
import com.omnie.shareyourviewservice.hibermapping.Post;
import com.omnie.shareyourviewservice.hibermapping.User;
import com.omnie.shareyourviewservice.utility.CloneBeanToDomain;

/**
 * @author Saurabh.srivastava
 *
 */
@Service
public class PostHandleServiceImpl implements PostHandleServiceInterface {

	@Autowired
	private PostHandleDAO postHandleDAO;
	
	/* (non-Javadoc)
	 * @see com.omnie.shareyourviewservice.service.PostHandleServiceInterface#pushUserPost(com.omnie.shareyourviewservice.beans.PostBean)
	 */
	@Override
	public void pushUserPost(PostBean bean) {
		Post post = CloneBeanToDomain.clonePostBeanToPost(bean);
		post.setUser(postHandleDAO.getUser(bean.getUser().getUserId()));
		postHandleDAO.pushUserPost(post);
		
	}

	/* (non-Javadoc)
	 * @see com.omnie.shareyourviewservice.service.PostHandleServiceInterface#pushUserCommentToPost(com.omnie.shareyourviewservice.beans.PostBean)
	 */
	@Override
	public void pushUserCommentToPost(CommentBean commentBean) {
		Post post = postHandleDAO.getPostByPostId(commentBean.getPostid());
		Comment comment = CloneBeanToDomain.cloneCommentBeanToComment(commentBean);
		comment.setPost(post);
		User user = postHandleDAO.getUser(commentBean.getUser().getUserId());
		comment.setUser(user);
		postHandleDAO.pushUserCommentToPost(comment);
		
	}

	/* (non-Javadoc)
	 * @see com.omnie.shareyourviewservice.service.PostHandleServiceInterface#getAllPost()
	 */
	
	/*public List<Post> getAllPost() {
		return postHandleDAO.getAllPost();
	}*/
	
	
	public List<PostBean> getAllPostBean() {
		List<PostBean> listPostBean = null;
		Set<CommentBean> commentSet = null;
		CommentBean commentBean = null;
		UserBean userBean = null;
		PostBean postBean = null;
		List<Post> listPost = postHandleDAO.getAllPost();
		if(listPost.size()>0){
			listPostBean = new ArrayList<PostBean>();
		for(Post post : listPost){
			postBean = new PostBean();
			postBean.setDescription(post.getDescription());
			postBean.setImage(post.getImage());
			postBean.setSubject(post.getSubject());
			postBean.setId(post.getId());
			userBean = new UserBean();
			userBean.setUserId(post.getUser().getUserId());
			postBean.setUser(userBean);
			commentSet = new HashSet<CommentBean>();
			for(Comment comment : post.getComments()){
				commentBean = new CommentBean();
				commentBean.setComment(comment.getComment());
				commentBean.setId(comment.getId());
				commentBean.setPostid(comment.getPost().getId());
				userBean = new UserBean();
				userBean.setUserId(comment.getUser().getUserId());
				commentBean.setUser(userBean);
				commentSet.add(commentBean);
			}
			
			postBean.setComments(commentSet);
			
			listPostBean.add(postBean);
			//postBean.setComments(post.getComments());
		}
		}
		
		return listPostBean;
	}

	/* (non-Javadoc)
	 * @see com.omnie.shareyourviewservice.service.PostHandleServiceInterface#getAllPostByUser(com.omnie.shareyourviewservice.beans.UserBean)
	 */
	
	/*public List<Post> getAllPostByUser(UserBean userBean) {
		User user = CloneBeanToDomain.cloneUserBeanToUser(userBean);
		List<Post> listPost = postHandleDAO.getAllPostByUser(user);;
		return postHandleDAO.getAllPostByUser(user);
	}
	*/
	
	@Override
	public List<PostBean> getAllPostBeanByUser(String userid) {
		List<PostBean> listPostBean = null;
		Set<CommentBean> commentSet = null;
		CommentBean commentBean = null;
		PostBean postBean = null;
		UserBean userBean = null;
		//User user = CloneBeanToDomain.cloneUserBeanToUser(userBean);
		List<Post> listPost = postHandleDAO.getAllPostByUser(userid);
		if(listPost.size()>0){
			listPostBean = new ArrayList<PostBean>();
		for(Post post : listPost){
			postBean = new PostBean();
			postBean.setDescription(post.getDescription());
			postBean.setImage(post.getImage());
			postBean.setSubject(post.getSubject());
			postBean.setId(post.getId());
			commentSet = new HashSet<CommentBean>();
			for(Comment comment : post.getComments()){
				commentBean = new CommentBean();
				commentBean.setComment(comment.getComment());
				commentBean.setId(comment.getId());
				commentBean.setPostid(comment.getPost().getId());
				userBean = new UserBean();
				userBean.setUserId(comment.getUser().getUserId());
				commentBean.setUser(userBean);
				commentSet.add(commentBean);
			}
			
			postBean.setComments(commentSet);
			listPostBean.add(postBean);
			//postBean.setComments(post.getComments());
		}
		}
		
		return listPostBean;
	}
	
	

	@Override
	public PostBean getPostByPostId(Long postid) {
		Post post = postHandleDAO.getPostByPostId(postid);
		Set<CommentBean> commentSet = null;
		CommentBean commentBean = null;
		UserBean userBean = null;
		PostBean postBean = new PostBean();
		postBean.setDescription(post.getDescription());
		postBean.setImage(post.getImage());
		postBean.setSubject(post.getSubject());
		postBean.setId(post.getId());
		commentSet = new HashSet<CommentBean>();
		for(Comment comment : post.getComments()){
			commentBean = new CommentBean();
			commentBean.setComment(comment.getComment());
			commentBean.setId(comment.getId());
			commentBean.setPostid(comment.getPost().getId());
			userBean = new UserBean();
			userBean.setUserId(comment.getUser().getUserId());
			commentBean.setUser(userBean);
			commentSet.add(commentBean);
		}
		
		postBean.setComments(commentSet);
		return postBean;
	}

	@Override
	public User getUser(String userid) {
		
		return postHandleDAO.getUser(userid);
	}

}
