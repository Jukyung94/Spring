package com.project.realworld.controller;

import com.project.realworld.dto.LoginUserRequest;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.entity.RealWorldUser;
import com.project.realworld.entity.Response;
import com.project.realworld.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/aa")
    public String test() {
        return "hello";
    }

    //Post Request로 회원정보 받아서 서비스로 넘겨주기
    @PostMapping("")
    public ResponseEntity<Response> register(final @Valid @RequestBody RegisterUserRequest request) throws Exception {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<RealWorldUser> login(final @Valid @RequestBody LoginUserRequest request) throws Exception {
        var user = userService.login(request);
        return ResponseEntity.ok(user);
    }


}
