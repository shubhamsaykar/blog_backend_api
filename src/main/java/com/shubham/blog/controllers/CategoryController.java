package com.shubham.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.blog.payloads.ApiResponse;
import com.shubham.blog.payloads.CategoryDto;
import com.shubham.blog.services.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

//	To create the category
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategory, HttpStatus.CREATED);

	}

//	to get the category
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId) {
		CategoryDto getCategory = this.categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(getCategory);
	}

//	to get List of the categories
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		return ResponseEntity.ok(this.categoryService.getAllCategories());

	}

//	to update the category

	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer categoryId) {
		CategoryDto updateCategory = this.categoryService.updateSingleCategory(categoryDto, categoryId);
		return ResponseEntity.ok(updateCategory);
	}

//		to delete the category
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Integer categoryId) {
		this.categoryService.deleteCategoryById(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted succesfully.", true), HttpStatus.OK);
	}
}
