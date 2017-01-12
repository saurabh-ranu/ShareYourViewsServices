package com.omnie.shareyourviewservice.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDetails {
	private String userName;
	private String emailId;
	private List<UserTest> userTest;
	
	
	@XmlElement (name="usertest")
	@XmlElementWrapper(name="usertests")
	public List<UserTest> getUserTest() {
		return userTest;
	}
	public void setUserTest(List<UserTest> userTest) {
		this.userTest = userTest;
	}
	/*@XmlElement(name="usertest")
	public UserTest getUserTest() {
		return userTest;
	}
	public void setUserTest(UserTest userTest) {
		this.userTest = userTest;
	}*/
	@XmlElement(name="username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement(name="emailid")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
