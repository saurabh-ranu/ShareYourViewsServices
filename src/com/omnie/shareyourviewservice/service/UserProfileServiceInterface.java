package com.omnie.shareyourviewservice.service;

import com.omnie.shareyourviewservice.beans.UserBean;
import com.omnie.shareyourviewservice.beans.UserProfileBean;

public interface UserProfileServiceInterface {
	
	UserBean getUser(String id);
	void registerUser(UserBean userBean);

}
