package com.project.realworld.repository;


import com.project.realworld.entity.RealWorldUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepository {
    Map<String, RealWorldUser> userMap = new HashMap<>();
    public void registration(RealWorldUser realWorldUser) throws Exception {
        System.out.println(realWorldUser.getEmail());
        if(userMap.containsKey(realWorldUser.getEmail())) {
            throw new Exception("The user already exist");
        }
        userMap.put(realWorldUser.getEmail(), realWorldUser);
    }

    public String login(RealWorldUser realWorldUser) {
        var values = userMap.values();
        boolean isUserExist = false;

        //Map에서 유저가 있는지 검증
        if(values.isEmpty()) {
            isUserExist = false;
        } else {
            for (RealWorldUser value : values) {
                System.out.println(value);
                isUserExist = Objects.equals(value.email, realWorldUser.email);
            }
        }
        if(!isUserExist) return "failed";
        else return "success";
    }
}
