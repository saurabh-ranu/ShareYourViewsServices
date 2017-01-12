package com.omnie.shareyourviewservice.service;

import java.util.List;

import com.omnie.shareyourviewservice.beans.CommentBean;
import com.omnie.shareyourviewservice.beans.PostBean;
import com.omnie.shareyourviewservice.hibermapping.Post;
import com.omnie.shareyourviewservice.hibermapping.User;

public interface PostHandleServiceInterface {

	public void pushUserPost(PostBean bean);
	public void pushUserCommentToPost(CommentBean comment);
	//public List<Post> getAllPost();
	//public List<Post> getAllPostByUser(UserBean userBean);
	public PostBean getPostByPostId(Long postid);
	public List<PostBean> getAllPostBean();
	List<PostBean> getAllPostBeanByUser(String userid);
	public User getUser(String userid);
}
