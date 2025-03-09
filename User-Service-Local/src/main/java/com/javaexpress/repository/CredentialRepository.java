package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Credentials;

public interface CredentialRepository extends JpaRepository<Credentials, Integer>{

}
