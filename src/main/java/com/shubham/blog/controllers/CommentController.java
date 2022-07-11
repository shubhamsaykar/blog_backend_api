package com.shubham.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.blog.payloads.ApiResponse;
import com.shubham.blog.payloads.CommentsDto;
import com.shubham.blog.services.CommentService;


@RestController
@RequestMapping("/api/comment/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}")
	public ResponseEntity<CommentsDto> createComment(@RequestBody CommentsDto commentsDto, @PathVariable Integer postId){
		CommentsDto createComment = this.commentService.createComment(commentsDto, postId);
		return new ResponseEntity<CommentsDto>(createComment,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer id){
		this.commentService.deleteComment(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Delete Successfully!!!", true),HttpStatus.OK);
	}

}
