package com.eighteen.hundred.flowers.response;

import java.util.List;

import com.eighteen.hundred.flowers.model.UserPost;

public class GetUserPostListResponse extends BaseResponse {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<UserPost> userPost;

	public List<UserPost> getUserPost() {
		return userPost;
	}

	public void setUserPost(List<UserPost> userPost) {
		this.userPost = userPost;
	}
       
    
}
