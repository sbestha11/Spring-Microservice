package com.javaexpress.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaexpress.model.RoleBasedAuthority;
import com.javaexpress.model.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CredentialDto {

	private Integer credentialId;
	private String userName;
	private String password;
	private RoleBasedAuthority roleBasedAuthority;
	private boolean isEnabled;
	private boolean isAccountNonExpired;
	private String isAccountNonLocked;
	private boolean isCredentialNonExpired;

	@JsonProperty("users")
	private Users user;
}
