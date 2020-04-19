package com.project.portal.service.impl;

import com.project.portal.dto.UserRegistration;
import com.project.portal.model.UserEntity;
import com.project.portal.repo.UserRepository;
import com.project.portal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
    public UserEntity registerUser(UserRegistration user) {
        UserEntity userEntity = convertDtoToDao(user);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (null == user)
            throw new UsernameNotFoundException("No user exists with username " + username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private UserRegistration convertDaoToDto(UserEntity dao) {
        return modelMapper.map(dao, UserRegistration.class);
    }

    private UserEntity convertDtoToDao(UserRegistration dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    private List<UserRegistration> convertDaoToDtoMultiple(List<UserEntity> dao) {
        return dao.stream().map(this::convertDaoToDto).collect(Collectors.toList());
    }

    private List<UserEntity> convertDtoToDaoMultiple(List<UserRegistration> dto) {
        return dto.stream().map(this::convertDtoToDao).collect(Collectors.toList());
    }
}
