package com.eighteen.hundred.flowers.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.eighteen.hundred.flowers.model.UserPost;
import com.eighteen.hundred.flowers.response.GetUniqueUserIdResponse;
import com.eighteen.hundred.flowers.response.GetUserPostListResponse;
import com.eighteen.hundred.flowers.response.UpdateUserPostResponse;

@Service
public class UserPostServiceImpl implements UserPostService {

	
    @Autowired
    private UserPostDao userPostDao;

	@Override
	public GetUniqueUserIdResponse findUniqueUserPost() {
		GetUniqueUserIdResponse response = new GetUniqueUserIdResponse();
		try {
			List<UserPost> findAllUserPostResponse = userPostDao.findAll();
			Long uniqueUserIdCount = findAllUserPostResponse != null ? findAllUserPostResponse.stream().map(UserPost::getUserId)
					.distinct().count() : null;
			response.setUserIdCount(uniqueUserIdCount);
			response.setStatus(HttpStatus.OK);
			response.setMessage("Unique User Ids Found");	
		}catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setUserIdCount(0l);
			response.setStatus(HttpStatus.NOT_FOUND);
		}
		return response;
	}



	@Override
	public GetUserPostListResponse findAllUserPost() {
		GetUserPostListResponse response = new GetUserPostListResponse();
		List<UserPost> userPosts = userPostDao.findAll();
		if (!userPosts.isEmpty()) {
			response.setUserPost(userPosts.stream().collect(Collectors.toList())); 
			response.setStatus(HttpStatus.FOUND);
			response.setMessage("user post list found");
		}else {
			response.setUserPost(null); 
			response.setStatus(HttpStatus.NOT_FOUND);
			response.setMessage("user post list not found");
		}
		return response;
	}



	@Override
	public UpdateUserPostResponse updateUserPost(UserPost userPost) {
		UserPost updatedUserPost = userPostDao.updateUserPost(userPost);
		UpdateUserPostResponse response = new UpdateUserPostResponse();
		response.setUserPost(updatedUserPost);
		if(updatedUserPost != null) {
			response.setStatus(HttpStatus.OK);
			response.setMessage("User Post Updated Successfully");
		}else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("User Post Updated Successfully");
		}
		return response;
	}
	
	
	
}
