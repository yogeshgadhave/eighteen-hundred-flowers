package com.eighteen.hundred.flowers.service;

import java.util.List;

import com.eighteen.hundred.flowers.model.UserPost;

public interface UserPostDao {
      
	public List<UserPost> findAll();
	public UserPost updateUserPost(UserPost userPost);
}
