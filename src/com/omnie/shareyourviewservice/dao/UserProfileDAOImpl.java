/**
 * 
 */
package com.omnie.shareyourviewservice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.omnie.shareyourviewservice.beans.UserProfileBean;
import com.omnie.shareyourviewservice.hibermapping.User;
import com.omnie.shareyourviewservice.hibermapping.UserProfile;

/**
 * @author Saurabh.srivastava
 *
 */
public class UserProfileDAOImpl implements UserProfileDAO {

	@Autowired
	protected SessionFactory syvsessionFactory;

	/**
	 * Get New Session from Session Factory
	 * 
	 * @return
	 */
	protected Session getSession() {
		return syvsessionFactory.getCurrentSession();
	}
	
	/* (non-Javadoc)
	 * @see com.omnie.shareyourviewservice.dao.UserProfileDAO#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String userid) {
		Session session = null;
		List<User> userList = null;
		try {
			session = getSession();
			Query query = session
					.createQuery("from com.omnie.shareyourviewservice.hibermapping.User where user_id =:user_id");
			userList = query.setParameter("user_id", userid).list();
			// TODO Auto-generated method stub
			System.out.println("userList " + userList);
				} finally {
			
		}
		return (null!=userList &&userList.size() > 0) ? userList.get(0) : null;
	}

	/* (non-Javadoc)
	 * @see com.omnie.shareyourviewservice.dao.UserProfileDAO#registerUser(com.omnie.shareyourviewservice.beans.UserProfileBean)
	 */
	@Override
	public void registerUser(UserProfileBean userProfieBean) {
		// TODO Auto-generated method stub
		Session session = null;
		session = getSession();
		session.save(userProfieBean);
	}

}
