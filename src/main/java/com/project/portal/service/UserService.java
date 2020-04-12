package com.project.portal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.portal.dto.user.UserRegistration;
import com.project.portal.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

	ModelMapper modelMapper = new ModelMapper();

	Optional<User> findById(long id);
	
	User createUser(User user);

	User registerUser(UserRegistration UserRegistration);

	default UserRegistration convertDaoToDto(User dao) {
		return modelMapper.map(dao, UserRegistration.class);
	}

	default User convertDtoToDao(UserRegistration dto) {
		return modelMapper.map(dto, User.class);
	}

	default List<UserRegistration> convertDaoToDtoMultiple(List<User> dao) {
		return dao.stream().map(this::convertDaoToDto).collect(Collectors.toList());
	}

	default List<User> convertDtoToDaoMultiple(List<UserRegistration> dto) {
		return dto.stream().map(this::convertDtoToDao).collect(Collectors.toList());
	}
}
