package com.omnie.shareyourviewservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.omnie.shareyourviewservice.dao.PostHandleDAO;
import com.omnie.shareyourviewservice.hibermapping.User;
import com.omnie.shareyourviewsservice.security.model.SpringSecurityUser;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PostHandleDAO postHandleDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("username "+username);
    	User appUser = postHandleDAO.getUser(username);

        if (appUser == null) {
            throw new UsernameNotFoundException(String.format("No appUser found with username '%s'.", username));
        } else {
        	return new SpringSecurityUser(appUser.getUserId(),
        			appUser.getPassword(),
                    appUser.getUserId(),  null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getUserrole().getRole()));
        	
            
        }
    }

}
