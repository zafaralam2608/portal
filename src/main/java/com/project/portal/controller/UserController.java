package com.project.portal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.portal.model.User;
import com.project.portal.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("user/{id}")
	public Optional<User> getUser(@PathVariable("id") long id) {
		return userService.findById(id);
	}

	@PostMapping("user/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
