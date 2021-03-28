package com.eighteen.hundred.flowers.service;

import com.eighteen.hundred.flowers.model.UserPost;
import com.eighteen.hundred.flowers.response.GetUniqueUserIdResponse;
import com.eighteen.hundred.flowers.response.GetUserPostListResponse;
import com.eighteen.hundred.flowers.response.UpdateUserPostResponse;

public interface UserPostService {

	public GetUserPostListResponse findAllUserPost();
	public GetUniqueUserIdResponse findUniqueUserPost();
	public UpdateUserPostResponse updateUserPost(UserPost userPost);
	
}
