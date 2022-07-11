package com.shubham.blog.services;

import com.shubham.blog.payloads.CommentsDto;

public interface CommentService {
	
	CommentsDto createComment(CommentsDto commentsDto, Integer postId);
	
	void deleteComment(int commentId);
	
	

}
