package com.omnie.shareyourviewservice.beans;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="role")
public class RoleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643357196984406244L;
	private Long id;
	private String role;
	private Set<UserBean> users = new HashSet<UserBean>(0);

	public RoleBean() {
	}

	public RoleBean(String role) {
		this.role = role;
	}

	public RoleBean(String role, Set<UserBean> users) {
		this.role = role;
		this.users = users;
	}

	@XmlElement
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement
	public String getRole() {
		return this.role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	@XmlElement(name="user")
	@XmlElementWrapper(name="users")
	public Set<UserBean> getUsers() {
		return this.users;
	}

	public void setUsers(Set<UserBean> users) {
		this.users = users;
	}

}
