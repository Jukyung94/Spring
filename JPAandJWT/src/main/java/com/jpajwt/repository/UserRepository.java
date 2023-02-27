package com.jpajwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpajwt.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
}
 