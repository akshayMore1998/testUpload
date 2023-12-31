package com.rest.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservice.entity.User;
import com.rest.webservice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User savedUser= userService.createUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId)
	{
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
//	@PutMapping("{id}")
//	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,@RequestBody User user )
//	{
//		user.setId(userId);
//		User updateUser= userService.updateUser(user);
//		return new ResponseEntity<User>(updateUser, HttpStatus.OK);
//		
//	}
	
	@PutMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User delteed ", HttpStatus.OK);
	}
	
	
	
}
