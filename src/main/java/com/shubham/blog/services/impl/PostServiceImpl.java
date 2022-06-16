package com.shubham.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.blog.entities.Category;
import com.shubham.blog.entities.Post;
import com.shubham.blog.entities.User;
import com.shubham.blog.exceptions.ResourceNotFoundException;
import com.shubham.blog.payloads.PostDto;
import com.shubham.blog.repositories.CategoryRepo;
import com.shubham.blog.repositories.PostRepo;
import com.shubham.blog.repositories.UserRepo;
import com.shubham.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "User Id", userId));

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Categoty", " Category Id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setPostedDate(new Date());
		post.setUser(user);
		post.setCategory(category);

		Post newPost = this.postRepo.save(post);

		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

		this.postRepo.delete(post);

	}

	@Override
	public PostDto getPostByPostId(Integer postId) {

		return null;
	}

	@Override
	public List<PostDto> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostBycategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "CategoryId", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
//		System.out.println(" post data" + posts.toString());
		List<PostDto> categoryPostDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
//		System.out.println(" new post data" + categoryPostDtos.toString());
		return categoryPostDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User id = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "User Id", userId));
		List<Post> posts = this.postRepo.findByUser(id);
//		System.out.println("data by post" + posts);
		List<PostDto> userPostDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return userPostDtos;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
