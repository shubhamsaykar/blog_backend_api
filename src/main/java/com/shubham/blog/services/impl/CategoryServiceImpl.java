package com.shubham.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.blog.entities.Category;
import com.shubham.blog.exceptions.ResourceNotFoundException;
import com.shubham.blog.payloads.CategoryDto;
import com.shubham.blog.repositories.CategoryRepo;
import com.shubham.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;

	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

	public Category dtoToCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		return category;
	}

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.dtoToCategory(categoryDto);
		Category saveCategory = this.categoryRepo.save(category);
		return this.categoryToDto(saveCategory);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow( () -> new ResourceNotFoundException("Category","Id",categoryId));
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos= categories.stream().map( category ->this.categoryToDto(category)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public CategoryDto updateSingleCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Id",categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category Updatecategory=this.categoryRepo.save(category);
		CategoryDto categoryDto2 = this.categoryToDto(Updatecategory);
		return categoryDto2;
	}

	@Override
	public void deleteCategoryById(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow( ()-> new ResourceNotFoundException("Category","Id",categoryId));
		this.categoryRepo.delete(category);
	}

}
