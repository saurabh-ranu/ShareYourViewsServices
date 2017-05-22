package com.omnie.shareyourviewservice.beans;

import java.io.Serializable;

// Generated Jun 26, 2014 12:47:14 PM by Hibernate Tools 3.4.0.CR1

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="comment")
public class CommentBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1943743731511932627L;
	private Long id;
	private UserBean user;
	private PostBean post;
	private Long postid;
	public Long getPostid() {
		return postid;
	}

	public void setPostid(Long postid) {
		this.postid = postid;
	}

	private String comment;
	private String image;

	public CommentBean() {
	}

	public CommentBean(PostBean post) {
		this.post = post;
	}

	public CommentBean(UserBean user, PostBean post, String comment, String image) {
		this.user = user;
		this.post = post;
		this.comment = comment;
		this.image = image;
	}

	@XmlElement
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="user")
	public UserBean getUser() {
		return this.user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	@XmlElement(name="post")
	public PostBean getPost() {
		return this.post;
	}

	public void setPost(PostBean post) {
		this.post = post;
	}

	@XmlElement(name="comment")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@XmlElement
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
