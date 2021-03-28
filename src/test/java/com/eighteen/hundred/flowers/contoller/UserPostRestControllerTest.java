package com.eighteen.hundred.flowers.contoller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.eighteen.hundred.flowers.model.UserPost;
import com.eighteen.hundred.flowers.response.GetUniqueUserIdResponse;
import com.eighteen.hundred.flowers.response.GetUserPostListResponse;
import com.eighteen.hundred.flowers.response.UpdateUserPostResponse;
import com.eighteen.hundred.flowers.service.UserPostDao;
import com.eighteen.hundred.flowers.service.UserPostService;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserPostRestControllerTest {
	
	@InjectMocks
	private UserPostRestController userPostRestController;
	
	@Mock
	private UserPostService userPostService;
	
	@Mock
	private UserPostDao userPostDao;
	
	@Value("${local.server.port}")
    private Integer port;
	
	public final String BASE_URL = "http://localhost:9091/eighteen-hundred-flower";

	public String getBaseUrl() {
		return BASE_URL.replace("9091", port.toString());
	}

	@Test
	void testGetUserPosts() {
		GetUserPostListResponse response = new GetUserPostListResponse();
		response.setUserPost(new ArrayList<>());
		response.setStatus(HttpStatus.FOUND);
		response.setMessage("Unique User Ids Found");	
		when(userPostService.findAllUserPost()).thenReturn(response);
		assertEquals(HttpStatus.FOUND, userPostRestController.getUserPosts().getStatus());
	}
	
	@Test
	void testGetUserPostsWithException() {
		GetUserPostListResponse response = new GetUserPostListResponse();
		response.setUserPost(new ArrayList<>());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setMessage("Unique User Ids Found");	
		when(userPostService.findAllUserPost()).thenReturn(response);
		assertEquals(HttpStatus.NOT_FOUND, userPostRestController.getUserPosts().getStatus());
	}

	@Test
	void testGetUniqueUserIds() {
		GetUniqueUserIdResponse response = new GetUniqueUserIdResponse();
		response.setUserIdCount(1l);
		response.setStatus(HttpStatus.OK);
		response.setMessage("Unique User Ids Found");	
		when(userPostService.findUniqueUserPost()).thenReturn(response);
		assertEquals(HttpStatus.OK, userPostRestController.getUniqueUserIds().getStatus());   
	}
	
	@Test
	public void updateUserPost() {
		RestTemplate restTemplate = new RestTemplate();
		final String updateUserPostUrl = getBaseUrl() + "/user-post/update";
		UserPost userPost = new UserPost();
		ResponseEntity<UpdateUserPostResponse> updateResponse = restTemplate.postForEntity(updateUserPostUrl, userPost, UpdateUserPostResponse.class);
		assertEquals(HttpStatus.OK, updateResponse.getBody().getStatus()); 
	}

}
