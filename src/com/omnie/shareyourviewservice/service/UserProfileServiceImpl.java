package com.omnie.shareyourviewservice.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omnie.shareyourviews.framework.exception.ServiceException;
import com.omnie.shareyourviewservice.beans.UserBean;
import com.omnie.shareyourviewservice.beans.UserProfileBean;
import com.omnie.shareyourviewservice.dao.UserProfileDAO;
import com.omnie.shareyourviewservice.hibermapping.User;
import com.omnie.shareyourviewservice.hibermapping.UserProfile;
import com.omnie.shareyourviewservice.hibermapping.Userrole;

@Service
public class UserProfileServiceImpl implements UserProfileServiceInterface {

	@Autowired
	UserProfileDAO userProfileDAO;

	@Transactional
	@Override
	public void registerUser(UserBean userBean) {
		Set<UserProfile> userProfileSet = new HashSet<UserProfile>();
		for (UserProfileBean userProfileBean : userBean.getUserProfiles()) {
			UserProfile userProfile = new UserProfile();
			userProfile.setAboutYou(userProfileBean.getAboutYou());
			userProfile.setAddress(userProfileBean.getAddress());
			userProfile.setImage(userProfileBean.getImage());
			userProfile.setName(userProfileBean.getName());
			userProfile.setId(userProfileBean.getId());
			userProfileSet.add(userProfile);
		}
		User user = new User();
		user.setUserId(userBean.getUserId());
		user.setPassword(userBean.getPassword());
		Userrole role = new Userrole();
		role.setRole("ROLE_USER");
		role.setId(1l);
		user.setUserrole(role);
		user.setUserProfiles(userProfileSet);
		userProfileDAO.registerUser(user);
	}

	@Transactional
	@Override
	public UserBean getUser(String id) {
		User user = userProfileDAO.getUser(id);
		if (null == user) {
			throw new ServiceException("User Not Found");
		}
		UserBean userBean = new UserBean();
		userBean.setUserId(user.getUserId());
		userBean.setUserName(user.getUserId());
		Set<UserProfile> userProfileSet = user.getUserProfiles();
		Set<UserProfileBean> userProfileBeanSet = new HashSet<UserProfileBean>();
		for (UserProfile userProfile : userProfileSet) {
			UserProfileBean userProfileBean = new UserProfileBean();
			userProfileBean.setName(userProfile.getName());
			userProfileBean.setId(userProfile.getId());
			userProfileBean.setAddress(userProfile.getAddress());
			userProfileBean.setAboutYou(userProfile.getAboutYou());
			userProfileBean.setImage(userProfile.getImage());
			userProfileBeanSet.add(userProfileBean);
		}
		userBean.setUserProfiles(userProfileBeanSet);
		return userBean;

	}

}
