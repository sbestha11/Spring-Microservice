package com.javaexpress.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.UserDto;
import com.javaexpress.helper.UserMappingHelper;
import com.javaexpress.model.Users;
import com.javaexpress.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto save(UserDto userDto) {
		Users user = UserMappingHelper.mapToModel(userDto);
		log.info("user {}", user);
		Users dbUser = userRepository.save(user);
		UserDto dbUserDto = UserMappingHelper.mapToDto(dbUser);
		return dbUserDto;
	}

	@Override
	public UserDto findById(Integer userId) {
		return userRepository.findById(userId).map(UserMappingHelper::mapToDto)
				.orElseThrow(() -> new RuntimeException("User not found in Db"));
	}

	@Override
	public List<UserDto> findAll() {
		List<UserDto> userDtoList = userRepository.findAll().stream().sorted(Comparator.comparing(Users::getUserId))
				.map(UserMappingHelper::mapToDto).collect(Collectors.toList());
		return userDtoList;
	}

	@Override
	public UserDto update(Integer userId, UserDto userDto) {

		return null;
	}

	@Override
	public void delteById(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public UserDto findByUsername(String username) {
		return null;
	}
}
