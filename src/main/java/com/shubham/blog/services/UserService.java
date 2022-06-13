package com.shubham.blog.services;


import java.util.List;

import com.shubham.blog.payloads.UserDto;

public interface UserService {
//	to create user
	UserDto createUser(UserDto user);
	
//	to update the userdetails of userId of the User
	UserDto updateUser(UserDto user,Integer userId);
	
//	to get the user of perticular ID of the user
	UserDto getUserById(Integer userId);
	
//	to get All users
	List<UserDto> getAllUser();
	
//	to delet the User
	void deleteUser(Integer userId);
	

}
