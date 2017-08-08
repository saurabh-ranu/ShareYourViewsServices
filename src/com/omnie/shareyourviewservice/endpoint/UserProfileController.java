package com.omnie.shareyourviewservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omnie.shareyourviewservice.beans.UserBean;
import com.omnie.shareyourviewservice.beans.UserProfileBean;
import com.omnie.shareyourviewservice.service.UserProfileServiceInterface;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
	
	@Autowired
	UserProfileServiceInterface userProfileService;
	
	@RequestMapping(value = "/user", method= RequestMethod.POST,consumes={"application/xml", "application/json"},produces={"application/xml", "application/json"})
	public ResponseEntity<?> registerUser(@RequestBody UserBean userBean){
		userProfileService.registerUser(userBean);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Successfully Created");		
	}
	
	
	@RequestMapping(value = "/user/{id}", method= RequestMethod.GET,consumes={"application/xml", "application/json"},produces={"application/xml", "application/json"})
	public ResponseEntity<?> getUser(@PathVariable String id){
		UserBean userBean = userProfileService.getUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(userBean);		
	}
	

}
