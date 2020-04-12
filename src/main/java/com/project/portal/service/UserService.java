package com.project.portal.service;

import java.util.Optional;

import com.project.portal.model.User;

public interface UserService {

	Optional<User> findById(String id);
	
	User createUser(User user);

}
