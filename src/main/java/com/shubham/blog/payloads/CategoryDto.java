package com.shubham.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private int categoryId;
	
	@NotEmpty(message = "Title Cannot be empty!!")
	private String categoryTitle;
	
	@Size(min = 20, message = "Discription is too short.")
	@NotEmpty(message = "Discription Cannot be empty!!")
	private String categoryDescription;

}
