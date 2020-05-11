package com.project.portal.service;

import com.project.portal.dto.UserRegistration;
import com.project.portal.exceptions.UserAlreadyExistsException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public interface UserService {

    @Transactional
    void registerUser(UserRegistration user) throws UserAlreadyExistsException;
}
