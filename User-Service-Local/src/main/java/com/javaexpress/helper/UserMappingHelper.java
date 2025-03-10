package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import com.javaexpress.dto.CredentialDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.model.Credentials;
import com.javaexpress.model.Users;

public interface UserMappingHelper {

	public static Users mapToModel(UserDto userDto) {

		Users user = new Users();
		BeanUtils.copyProperties(userDto, user);
		if (userDto.getCredentialDto() != null) {
			Credentials credentials = new Credentials();
			BeanUtils.copyProperties(userDto.getCredentialDto(), credentials);
			credentials.setUsers(user);
			user.setCredentials(credentials);
		}
		return user;
	}

	public static UserDto mapToDto(Users user) {
		if (ObjectUtils.isEmpty(user)) {
			return null;
		}
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);

		if (!ObjectUtils.isEmpty(user.getCredentials())) {
			CredentialDto credentialDto = new CredentialDto();
			BeanUtils.copyProperties(user.getCredentials(), credentialDto);
			userDto.setCredentialDto(credentialDto);
		}
		return userDto;
	}

}
