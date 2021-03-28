package com.eighteen.hundred.flowers.response;

import com.eighteen.hundred.flowers.model.UserPost;

public class UpdateUserPostResponse extends BaseResponse {

	private UserPost userPost;

	public UserPost getUserPost() {
		return userPost;
	}

	public void setUserPost(UserPost userPost) {
		this.userPost = userPost;
	}

	@Override
	public String toString() {
		return "UpdateUserPostResponse [userPost=" + userPost + "]";
	}
		
}
