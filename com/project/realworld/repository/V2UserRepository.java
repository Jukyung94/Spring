package com.project.realworld.repository;


import com.project.realworld.dto.LoginUserRequest2;
import com.project.realworld.entity.RealWorldUser2;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class V2UserRepository {
    private final Map<String, RealWorldUser2> userMap = new HashMap<>();

    public RealWorldUser2 registration(RealWorldUser2 realWorldUser) {
        log.info("registration() : realWorldUser.getEmail()={}", realWorldUser.getEmail());
        if(userMap.containsKey(realWorldUser.getEmail())) {
            throw new IllegalArgumentException("email or password is invalid");
        }
        userMap.put(realWorldUser.getEmail(), realWorldUser);

        return realWorldUser;
    }

    public RealWorldUser2 login(LoginUserRequest2 request) {
        if(! userMap.containsKey(request.getEmail())) {
            throw new IllegalArgumentException("email or password is invalid");
        }

        val foundUser = userMap.get(request.getEmail());
        if (!foundUser.getEmail().equals(request.getEmail()) ||
                !foundUser.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("email or password is invalid");
        }

        return foundUser;
    }
}
