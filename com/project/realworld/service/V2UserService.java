package com.project.realworld.service;

import com.project.realworld.dto.LoginUserRequest2;
import com.project.realworld.dto.RegisterUserRequest2;
import com.project.realworld.entity.RealWorldUser2;
import com.project.realworld.entity.UserResponse2;
import com.project.realworld.repository.V2UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor    //private final 로 되어있는 멤버변수를 생성자 파라미터로 주입하는 역할.
public class V2UserService {
    private final V2UserRepository v2UserRepository;

    public UserResponse2 register(RegisterUserRequest2 request) throws Exception {
        RealWorldUser2 realWorldUser = new RealWorldUser2(request);

        val registeredUser = v2UserRepository.registration(realWorldUser);

        return UserResponse2.builder()
                .email(registeredUser.getEmail())
                .username(registeredUser.getUsername())
                .token("token")
                .build();
    }

    public UserResponse2 login(LoginUserRequest2 request) {
        val foundUser = v2UserRepository.login(request);

        return UserResponse2.builder()
                .email(foundUser.getEmail())
                .username(foundUser.getUsername())
                .token("token")
                .bio(foundUser.getBio())
                .image(foundUser.getImage())
                .build();
    }
}
