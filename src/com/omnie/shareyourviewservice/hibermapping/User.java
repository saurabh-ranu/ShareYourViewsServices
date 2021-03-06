package com.omnie.shareyourviewservice.hibermapping;

// Generated Sep 1, 2015 2:49:52 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "shareyourviewdb")
public class User implements java.io.Serializable {

	private String userId;
	private Userrole userrole;
	private String password;
	private byte enabled;
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Post> posts = new HashSet<Post>(0);

	public User() {
	}

	public User(String userId, String password, byte enabled) {
		this.userId = userId;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String userId, Userrole userrole, String password,
			byte enabled, Set<UserProfile> userProfiles, Set<Comment> comments,
			Set<Post> posts) {
		this.userId = userId;
		this.userrole = userrole;
		this.password = password;
		this.enabled = enabled;
		this.userProfiles = userProfiles;
		this.comments = comments;
		this.posts = posts;
	}

	@Id
	@Column(name = "user_id", unique = true, nullable = false, length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public Set<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
