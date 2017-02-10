package com.omnie.shareyourviewservice.dao;

import java.util.List;

import com.omnie.shareyourviewservice.hibermapping.Comment;
import com.omnie.shareyourviewservice.hibermapping.Post;
import com.omnie.shareyourviewservice.hibermapping.User;

public interface PostHandleDAO {
	
	public void pushUserPost(Post bean);
	public void pushUserCommentToPost(Comment comment);
	public Post getPostByPostId(Long postid);
	public List<Post> getAllPost();
	public List<Post> getAllPostByUser(String userid);
	public User getUser(String userid);


}
