package com.project.portal.server.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.portal.server.model.User;
import com.project.portal.server.repo.UserRepository;
import com.project.portal.server.service.UserService;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	UserRepository userRepository;

	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

}
