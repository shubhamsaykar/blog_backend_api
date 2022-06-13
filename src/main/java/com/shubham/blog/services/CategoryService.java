package com.shubham.blog.services;

import java.util.List;


import com.shubham.blog.payloads.CategoryDto;

public interface CategoryService {
//  to create category
	public CategoryDto createCategory(CategoryDto categoryDto);
	
//	to get the category
	public CategoryDto getCategoryById(Integer categoryId);
	
//	to get List Of categories
	public List<CategoryDto> getAllCategories();
	
//	to update category
	public CategoryDto updateSingleCategory(CategoryDto categoryDto,Integer categoryId);
	
//	to delete category
	public void deleteCategoryById(Integer categoryId);
}
