package com.omnie.shareyourviewservice.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Generated Jun 26, 2014 12:47:14 PM by Hibernate Tools 3.4.0.CR1

@XmlRootElement(name="userprofilebean")
public class UserProfileBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6693028918660235345L;
	private long id;
	private UserBean user;
	private String name;
	private String address;
	private String image;
	private String aboutYou;

	public UserProfileBean() {
	}

	public UserProfileBean(long id, UserBean user) {
		this.id = id;
		this.user = user;
	}

	public UserProfileBean(long id, UserBean user, String name, String address,
			String image, String aboutYou) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.address = address;
		this.image = image;
		this.aboutYou = aboutYou;
	}

	@XmlElement
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

	@XmlElement(name="user")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name="image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@XmlElement(name="aboutyou")
	public String getAboutYou() {
		return this.aboutYou;
	}

	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}

}
