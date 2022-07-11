package com.shubham.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.blog.entities.Comment;
import com.shubham.blog.entities.Post;
import com.shubham.blog.exceptions.ResourceNotFoundException;
import com.shubham.blog.payloads.CommentsDto;
import com.shubham.blog.repositories.CommentRepo;
import com.shubham.blog.repositories.PostRepo;
import com.shubham.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {


	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Override
	public CommentsDto createComment(CommentsDto commentsDto, Integer postId) {
		
		Post post =this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post Id", postId));
		Comment comment = this.modelMapper.map(commentsDto, Comment.class);
		comment.setPost(post);
		Comment savedComments = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComments, CommentsDto.class);	
		
//		return commentDto;
	}

	@Override
	public void deleteComment(int commentId) {
		Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment","comment Id", commentId));
		this.commentRepo.delete(com);
	}

}
