package com.project.portal.service.impl;

import com.project.portal.dto.UserRegistration;
import com.project.portal.model.Role;
import com.project.portal.model.User;
import com.project.portal.repo.RoleRepository;
import com.project.portal.repo.UserRepository;
import com.project.portal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void registerUser(UserRegistration userDto) {
        User user = convertDtoToDao(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
    }

    private UserRegistration convertDaoToDto(User dao) {
        return modelMapper.map(dao, UserRegistration.class);
    }

    private User convertDtoToDao(UserRegistration dto) {
        return modelMapper.map(dto, User.class);
    }

    private List<UserRegistration> convertDaoToDtoMultiple(List<User> dao) {
        return dao.stream().map(this::convertDaoToDto).collect(Collectors.toList());
    }

    private List<User> convertDtoToDaoMultiple(List<UserRegistration> dto) {
        return dto.stream().map(this::convertDtoToDao).collect(Collectors.toList());
    }
}
