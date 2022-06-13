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
import com.shubham.blog.payloads.UserDto;
import com.shubham.blog.services.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserService userService;

//	this method is used to create the user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUser = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

//	this method is used to update user 
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUserById(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
		UserDto updateUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updateUser);

	}

//	this method is used to delete the user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable("userId") Integer uid) {

		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully.", true), HttpStatus.OK);

	}

//	this method is used to get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUser());

	}

//	this method is used to get single user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUserById(@PathVariable("userId") Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));

	}
}
