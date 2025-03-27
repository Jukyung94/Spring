package com.project.realworld.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.realworld.dto.LoginUserRequest;
import com.project.realworld.dto.RegisterUserRequest;
import com.project.realworld.entity.RealWorldUser;
import com.project.realworld.entity.Response;
import com.project.realworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public Response register(RegisterUserRequest request) throws Exception {
        RealWorldUser realWorldUser = new RealWorldUser();
        realWorldUser.setUserInfo(request);
        try {
            userRepository.registration(realWorldUser);
            return Response.builder()
                    .code("200")
                    .message("register success")
                    .data(ObjectCreater(realWorldUser))
                    .build();
        } catch (Exception e) {
            return Response.builder()
                    .code("-300")
                    .message(e.getMessage())
                    .data("")
                    .build();
        }
    }

    public RealWorldUser login(LoginUserRequest request) {
        RealWorldUser realWorldUser = new RealWorldUser();
        realWorldUser.setEmail(request.getEmail());
        realWorldUser.setPassword(request.getPassword());
        if(userRepository.login(realWorldUser).equals("success")) return realWorldUser;
        else return realWorldUser;

    }


    public String ObjectCreater(RealWorldUser realWorldUser) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(realWorldUser);
        System.out.println(jsonString);
        return jsonString;
    }
}
