package com.eighteen.hundred.flowers.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.eighteen.hundred.flowers.model.UserPost;
import com.eighteen.hundred.flowers.util.ApplicationPropertyReader;

@Repository
public class UserPostDaoImpl implements UserPostDao {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ApplicationPropertyReader applicationPropertyReader;
	
	
	@Override
	public List<UserPost> findAll() {
		ResponseEntity<UserPost[]> responseEntity = restTemplate
				.getForEntity(applicationPropertyReader.getUserPostUrl(), UserPost[].class);
		if (responseEntity != null && responseEntity.getBody() != null) {
			return Arrays.asList(responseEntity.getBody()); 
		}
		return Collections.emptyList();
	}


	@Override
	public UserPost updateUserPost(UserPost userPost) {
		UserPost foundUserPost = findAll().stream().filter(uPost -> userPost.getId().equals(uPost.getId()))
				.findFirst().get();
		foundUserPost.setTitle(userPost.getTitle());
		foundUserPost.setBody(userPost.getBody());
		return foundUserPost;
	}

}
