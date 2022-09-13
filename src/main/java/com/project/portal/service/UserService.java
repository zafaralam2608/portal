package com.project.portal.service;

import com.project.portal.dto.UserRegistration;
import com.project.portal.exceptions.UserAlreadyExistsException;
import com.project.portal.model.Role;
import com.project.portal.model.User;
import com.project.portal.repo.RoleRepository;
import com.project.portal.repo.UserRepository;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    /** The ModelMapper dependency. */
    @Autowired
    private ModelMapper modelMapper;

    /** The PasswordEncoder dependency. */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /** The UserRepository dependency. */
    @Autowired
    private UserRepository userRepository;

    /** The RoleRepository dependency. */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Registers a user.
     *
     * @param userDto the user resource
     */
    @Transactional
    public void registerUser(final UserRegistration userDto)
            throws UserAlreadyExistsException {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new UserAlreadyExistsException(
                    "A user already exists with this username ");
        }
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new UserAlreadyExistsException(
                    "A user already exists with this email ");
        }
        User user = convertDtoToDao(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singletonList(userRole));
        userRepository.save(user);
    }

    private User convertDtoToDao(final UserRegistration dto) {
        return modelMapper.map(dto, User.class);
    }
}
