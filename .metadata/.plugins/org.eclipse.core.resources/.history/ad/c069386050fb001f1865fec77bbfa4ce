package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.UserDto;
import com.javaexpress.model.Credential;
import com.javaexpress.model.User;

public interface UserMappingHelper {

	public static User map(UserDto userDto) {

		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		if (userDto.getCredentialDto() != null) {
			Credential credential = new Credential();
			BeanUtils.copyProperties(userDto.getCredentialDto(), credential);
			
			user.setCredential(credential);
		}

		return user;
	}

	public static UserDto map(User user) {

		return null;
	}

}
