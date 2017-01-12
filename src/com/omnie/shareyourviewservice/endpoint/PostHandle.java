package com.omnie.shareyourviewservice.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.omnie.shareyourviewservice.beans.CommentBean;
import com.omnie.shareyourviewservice.beans.PostBean;
import com.omnie.shareyourviewservice.beans.UserDetails;
import com.omnie.shareyourviewservice.beans.UserTest;
import com.omnie.shareyourviewservice.service.PostHandleServiceInterface;
import com.omnie.shareyourviewservice.utility.JaxbListWrapper;


@Controller
@RequestMapping("/PostHandle")
public class PostHandle {

	static Logger log = Logger.getLogger(PostHandle.class.getName());
	
	@Autowired
	private PostHandleServiceInterface postHandleService;

	@RequestMapping(value = "/pushUserPost", method = RequestMethod.POST,consumes={"application/xml", "application/json"},produces={"application/xml", "application/json"})
	public @ResponseBody JaxbListWrapper<PostBean> pushUserPost(@RequestBody PostBean bean){
		log.info("In pushUserPost !!!! "+bean);
		postHandleService.pushUserPost(bean);
		//return postHandleService.getPostByPostId(bean.getId());
		//return postHandleService.getAllPostBeanByUser(userid);
		return new JaxbListWrapper<PostBean>(postHandleService.getAllPostBeanByUser(bean.getUser().getUserId()));
	}
	
	@RequestMapping(value = "/pushUserCommentToPost", method = RequestMethod.POST)
	public @ResponseBody PostBean  pushUserCommentToPost(@RequestBody CommentBean commentBean){
		postHandleService.pushUserCommentToPost(commentBean);
		return postHandleService.getPostByPostId(commentBean.getPostid());
	}
	
	/*@RequestMapping(value = "/getAllPost", method = RequestMethod.GET,produces={"application/xml", "application/json"})
	public  @ResponseBody List<PostBean> getAllPost(){
		return postHandleService.getAllPostBean();
	}*/
	

	@RequestMapping(value = "/getAllPost", method = RequestMethod.GET,produces={"application/xml", "application/json"})
	public  @ResponseBody JaxbListWrapper<PostBean> getAllPost(){
		//return postHandleService.getAllPostBean();
		return new JaxbListWrapper<PostBean>(postHandleService.getAllPostBean());
	}
	
	@RequestMapping(value = "/getAllPosts", method = RequestMethod.GET,produces={"application/xml", "application/json"})
	public  @ResponseBody ResponseEntity<UserDetails> getAllPosts(){
		ResponseEntity<UserDetails> responseEntity = null;
		UserDetails userDetails = new UserDetails();
		userDetails.setEmailId("test@test.test");
		userDetails.setUserName("testName");
		UserTest userTest = new UserTest();
		userTest.setTestName("testName");
		//userDetails.setUserTest(userTest);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        responseEntity = new ResponseEntity<UserDetails>(userDetails,headers, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(value = "/getAllPostsList", method = RequestMethod.GET,produces={"application/xml", "application/json","application/html"})
	public  @ResponseBody JaxbListWrapper<UserDetails> getAllPostsList(){
		ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
		ArrayList<UserTest> userTestList = new ArrayList<UserTest>();
		//ResponseEntity<List<UserDetails>> responseEntity = null;
		UserDetails userDetails = new UserDetails();
		userDetails.setEmailId("test@test.test");
		userDetails.setUserName("testName");
		UserTest userTest = new UserTest();
		userTest.setTestName("testName");
		userTestList.add(userTest);
		userTestList.add(userTest);
		userDetails.setUserTest(userTestList);
		userList.add(userDetails);
		userList.add(userDetails);
		//HttpHeaders headers = new HttpHeaders();
        //headers.add("Access-Control-Allow-Origin", "*");
       // responseEntity = new ResponseEntity<List<UserDetails>>(userList,headers, HttpStatus.OK);
		//return userList;
		return new JaxbListWrapper<UserDetails>(userList);
	}
	
	@RequestMapping(value = "/getAllPostByUser/{userid}", method = RequestMethod.GET,produces={"application/xml", "application/json"})
	public  @ResponseBody List<PostBean> getAllPostByUser(@PathVariable  String userid){
		return postHandleService.getAllPostBeanByUser(userid);
	}
	
	

}
