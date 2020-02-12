package com.project.portal.rest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.portal.server.model.User;
import com.project.portal.server.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("user/{id}")
	public Optional<User> getUser(@PathVariable("id") String id) {
		return userService.findById(id);
	}

	@PostMapping("user/create")
	public User createUser(User user) {
		return userService.createUser(user);
	}
}
