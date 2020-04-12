package com.project.portal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.portal.model.User;
import com.project.portal.repo.UserRepository;
import com.project.portal.service.UserService;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	UserRepository userRepository;

	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

}
