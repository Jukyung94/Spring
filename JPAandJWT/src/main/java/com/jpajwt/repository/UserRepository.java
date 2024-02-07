package com.jpajwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpajwt.user.Member;

public interface UserRepository extends JpaRepository<Member, Integer>{
	Optional<Member> findByEmail(String email);
}
 