package com.omnie.shareyourviewservice.utility;

import com.omnie.shareyourviewservice.beans.CommentBean;
import com.omnie.shareyourviewservice.beans.PostBean;
import com.omnie.shareyourviewservice.beans.UserBean;
import com.omnie.shareyourviewservice.hibermapping.Comment;
import com.omnie.shareyourviewservice.hibermapping.Post;
import com.omnie.shareyourviewservice.hibermapping.User;

public class CloneBeanToDomain{
	
	public static Post clonePostBeanToPost(PostBean postBean){
		
		Post post = new Post();
		//post.setCategory(postBean.getCategory());
		post.setDescription(postBean.getDescription());
		post.setSubject(postBean.getSubject());
		post.setUser(cloneUserBeanToUser(postBean.getUser()));
		return post;
	}
	
	
	public static User cloneUserBeanToUser(UserBean userBean){
		
		User user = new User();
		//post.setCategory(postBean.getCategory());
		user.setUserId(userBean.getUserId());
		return user;
	}
	
	
	public static Comment cloneCommentBeanToComment(CommentBean commentBean){
		Comment comment = new Comment();
		comment.setComment(commentBean.getComment());
		comment.setImage(commentBean.getImage());
		return comment;
		
	}

}
