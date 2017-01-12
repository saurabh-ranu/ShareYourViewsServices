package com.omnie.shareyourviewservice.beans;

// Generated Jun 26, 2014 12:47:14 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="posts")
public class PostBean  {

	private long id;
	private UserBean user;
	private String subject;
	private String description;
	private String image;
	private Set<CommentBean> comments = new HashSet<CommentBean>(0);

	public PostBean() {
	}

	public PostBean(long id, UserBean user) {
		this.id = id;
		
		this.user = user;
	}

	public PostBean(long id, UserBean user, String subject,
			String description, String image, Set<CommentBean> comments) {
		this.id = id;
		this.user = user;
		this.subject = subject;
		this.description = description;
		this.image = image;
		this.comments = comments;
	}

	@XmlElement(name="id")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement(name="user")
	public UserBean getUser() {
		return this.user;
	}

	
	public void setUser(UserBean user) {
		this.user = user;
	}

	@XmlElement
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@XmlElement
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@XmlElement(name="comment")
	@XmlElementWrapper(name="comments")
	public Set<CommentBean> getComments() {
		return this.comments;
	}

	public void setComments(Set<CommentBean> comments) {
		this.comments = comments;
	}

}
