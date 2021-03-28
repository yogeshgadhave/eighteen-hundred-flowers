package com.eighteen.hundred.flowers.contoller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eighteen.hundred.flowers.model.UserPost;
import com.eighteen.hundred.flowers.response.GetUniqueUserIdResponse;
import com.eighteen.hundred.flowers.response.GetUserPostListResponse;
import com.eighteen.hundred.flowers.response.UpdateUserPostResponse;
import com.eighteen.hundred.flowers.service.UserPostService;

@RestController
@RequestMapping(value = "/user-post")
public class UserPostRestController {
	
	
	private UserPostService userPostService;
	
	@Autowired
	public UserPostRestController(UserPostService userPostService) {
		this.userPostService = userPostService;
	}
	
	@GetMapping(value = "/find/list")
	public GetUserPostListResponse getUserPosts() {
		return userPostService.findAllUserPost();
	}
	
	@GetMapping(value = "/find/uniqueuserids")
	public GetUniqueUserIdResponse getUniqueUserIds() {
		return userPostService.findUniqueUserPost();	
	}
	
	@PostMapping(value = "/update")
	public UpdateUserPostResponse updateUserPost(@RequestBody UserPost userPost) {
		UserPost uPost = new UserPost();
		uPost.setId(4);
		uPost.setTitle("1800Flowers");
		uPost.setBody("1800Flowers");
		return userPostService.updateUserPost(uPost);	
	}

}
