package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.User;
import com.capg.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"},allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/admin/findAllUsers")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@PutMapping("/editUser/{id}")
	User editUser(@RequestBody User user, @PathVariable long id) {
		return userService.editUser(user, id);
	}

	@GetMapping("/findUserById/{id}")
	User findUserById(@PathVariable long id) {
		return userService.findUserById(id);
	}

	@DeleteMapping("/deleteUser/{id}")
	void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/findByUsername/{username}")
	User findByUsername(@PathVariable String username) {
		return userService.findByUsername(username);
	}

}
