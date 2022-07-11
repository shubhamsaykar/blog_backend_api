package com.shubham.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shubham.blog.entities.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto {

	private Integer postId;

	private String title;

	private String content;

	private String imageName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date postedDate;
	
	

//	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
//	private Date lastModifieddate;

	private CategoryDto category;

	private UserDto user;
	
	private Set<CommentsDto> comments = new HashSet<>();

}
