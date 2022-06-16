package com.shubham.blog.services;

import java.util.List;


import com.shubham.blog.payloads.PostDto;

public interface PostService {
	
//	to create post
	
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	
//	to update post
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
//	to delete post
	
	void deletePost(Integer postId);
	
	
//	to get single post
	
	PostDto getPostByPostId(Integer postId);
	
//	to get all post
	
	List<PostDto> getAllPosts();
	
	
//	to get all post by category
	List<PostDto> getPostBycategory (Integer categoryId);
	
//	to get all post by user
	
	List<PostDto> getPostByUser (Integer userId);
	
	
//	to get post using search keyword
	List<PostDto> searchPost (String keyword);

}
