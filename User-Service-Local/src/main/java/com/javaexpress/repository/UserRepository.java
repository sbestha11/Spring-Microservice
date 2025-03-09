package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
