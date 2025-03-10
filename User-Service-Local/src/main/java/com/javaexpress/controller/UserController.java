package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.UserDto;
import com.javaexpress.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping
	public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
		UserDto dbUserDto = userService.save(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbUserDto);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer userId) {
		log.info("UserController :: fetch user details");
		return ResponseEntity.ok(userService.findById(userId));
	}

}
