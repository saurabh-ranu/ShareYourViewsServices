package com.omnie.shareyourviewservice.dao;

import com.omnie.shareyourviewservice.beans.UserProfileBean;
import com.omnie.shareyourviewservice.hibermapping.User;
import com.omnie.shareyourviewservice.hibermapping.UserProfile;

public interface UserProfileDAO {
	
	public User getUser(String userid);
	public void registerUser(UserProfileBean userProfieBean);

}
