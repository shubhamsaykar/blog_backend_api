package com.shubham.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.blog.payloads.ApiResponse;
import com.shubham.blog.payloads.PostDto;
import com.shubham.blog.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;

//	to create new post
	@PostMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDto> createNewPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}

//	to delete post
	@DeleteMapping("/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post Deleted Successfully", true), HttpStatus.OK);
	}

//	to get post of users
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
		List<PostDto> userPosts = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(userPosts, HttpStatus.OK);
	}

//	to get posts of categories
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
		List<PostDto> categoryPosts = this.postService.getPostBycategory(categoryId);
		return new ResponseEntity<List<PostDto>>(categoryPosts, HttpStatus.OK);
	}
}
