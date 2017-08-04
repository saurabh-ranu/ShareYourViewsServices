package com.omnie.shareyourviewservice.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.omnie.shareyourviewservice.config.AppTestConfig;
import com.omnie.shareyourviewservice.config.DAOTestConfig;
import com.omnie.shareyourviewservice.hibermapping.Post;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= { DAOTestConfig.class , AppTestConfig.class }, loader=AnnotationConfigContextLoader.class )
public class PostHandleDAOTest {
	
	@Autowired
	private PostHandleDAO postHandleDAO;
	
	@Transactional
	@Test
	public void testGetAllPosts(){
		List<Post> listPost =  postHandleDAO.getAllPost();
		for(Post post:listPost){
			System.out.println(post);
		}
		
		Assert.assertNotNull(listPost);;
	}

}
