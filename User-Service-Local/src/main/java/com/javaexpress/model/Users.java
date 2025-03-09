package com.javaexpress.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String firstName;
	private String lastName;
	
	@Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
	private String email;
	
	@Column(unique = true)
	private String phone;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Address> addresses;

	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Credentials credentials;
}
