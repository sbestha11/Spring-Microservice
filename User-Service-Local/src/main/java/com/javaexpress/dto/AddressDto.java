package com.javaexpress.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaexpress.model.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddressDto {

	private Integer addressId;
	private String fullAddress;
	private String postalCode;
	private String city;
	
	@JsonProperty("user")
	private Users user;
}
