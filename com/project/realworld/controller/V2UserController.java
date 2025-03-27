package com.project.realworld.controller;

import com.project.realworld.dto.LoginUserRequest;
import com.project.realworld.dto.LoginUserRequest2;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.dto.RegisterUserRequest2;
import com.project.realworld.entity.RealWorldUser;
import com.project.realworld.entity.Response;
import com.project.realworld.entity.UserResponse2;
import com.project.realworld.entity.WrapUserResponse2;
import com.project.realworld.service.V2UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api2/users")
public class V2UserController {
    private final V2UserService v2UserService;

    @PostMapping("")
    public ResponseEntity<?> register(final @Valid @RequestBody RegisterUserRequest2 request) throws Exception {
        log.info("register() : request={}", request);

        UserResponse2 userResponse2 = v2UserService.register(request);
        log.info("register() : userResponse2={}", userResponse2);

        return ResponseEntity.ok(new WrapUserResponse2(userResponse2));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(final @Valid @RequestBody LoginUserRequest2 request) throws Exception {
        log.info("login() : request={}", request);

        val userResponse2 = v2UserService.login(request);
        log.info("login() : userResponse2={}", userResponse2);

        return ResponseEntity.ok(new WrapUserResponse2(userResponse2));
    }

}
