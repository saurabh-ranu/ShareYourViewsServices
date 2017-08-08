package com.omnie.shareyourviewservice.dao;

import com.omnie.shareyourviewservice.hibermapping.User;

public interface UserProfileDAO {
	
	public User getUser(String userid);
	void registerUser(User user);

}
