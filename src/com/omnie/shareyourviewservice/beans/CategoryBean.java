package com.omnie.shareyourviewservice.beans;

// Generated Jun 26, 2014 12:47:14 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="category")
public class CategoryBean {

	private long catId;
	private String catName;
	private Set<PostBean> posts = new HashSet<PostBean>(0);

	public CategoryBean() {
	}

	public CategoryBean(long catId) {
		this.catId = catId;
	}

	public CategoryBean(long catId, String catName, Set<PostBean> posts) {
		this.catId = catId;
		this.catName = catName;
		this.posts = posts;
	}
	
	
	public long getCatId() {
		return this.catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}

	@XmlElement
	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@XmlElement(name="posts")
	public Set<PostBean> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<PostBean> posts) {
		this.posts = posts;
	}

}
