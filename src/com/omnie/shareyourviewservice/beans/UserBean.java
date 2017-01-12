package com.omnie.shareyourviewservice.beans;


import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class UserBean{

	private String userId;
	private RoleBean role;
	private String userName;
	private Set<UserProfileBean> userProfiles = new HashSet<UserProfileBean>(0);
	private Set<CommentBean> comments = new HashSet<CommentBean>(0);
	private Set<PostBean> posts = new HashSet<PostBean>(0);

	public UserBean() {
	}

	public UserBean(String userId) {
		this.userId = userId;
	}

	public UserBean(String userId, RoleBean role, String userName,
			Set<UserProfileBean> userProfiles, Set<CommentBean> comments,
			Set<PostBean> posts) {
		this.userId = userId;
		this.role = role;
		this.userName = userName;
		this.userProfiles = userProfiles;
		this.comments = comments;
		this.posts = posts;
	}

	@XmlElement
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@XmlElement(name="role")
	public RoleBean getRole() {
		return this.role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}

	@XmlElement
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement(name="userprofilebean")
	public Set<UserProfileBean> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfileBean> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@XmlElement(name="comment")
	public Set<CommentBean> getComments() {
		return this.comments;
	}

	public void setComments(Set<CommentBean> comments) {
		this.comments = comments;
	}

	@XmlElement(name="posts")
	public Set<PostBean> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<PostBean> posts) {
		this.posts = posts;
	}

}
