package com.shubham.blog.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_Id")
	private Integer postId;
	

	private String title;
	
	@Column(length = 10000)
	private String content;
	
	private String imageName;
	
	private Date postedDate;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	
	
	

}
