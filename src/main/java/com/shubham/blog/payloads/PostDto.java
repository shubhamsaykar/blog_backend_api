package com.shubham.blog.payloads;

import java.util.Date;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto {

	private String title;

	private String content;

	private String imageName;

	private Date postedDate;

	private CategoryDto category;

	private UserDto user;

}
