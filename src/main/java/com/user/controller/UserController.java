package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;

	@GetMapping("/get/{id}")
	public User getUser(@PathVariable("id") int id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/get/all")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		if(userService.addUser(user)) {
			return "User added";
		}else {
			return "Failed operation";
		}
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id,@RequestBody User user) {
		if(userService.updateUser(id, user)) {
			return "Updated";
		}else {
			return "Failed Operation";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "Deleted";
	}
	
}
