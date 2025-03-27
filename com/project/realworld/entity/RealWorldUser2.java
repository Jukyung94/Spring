package com.project.realworld.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.project.realworld.dto.RegisterUserRequest2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // => @Getter, @Setter 등
@Builder
@JsonRootName("user")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RealWorldUser2 {
    private String username;
    private String email;
    private String password;
    private String bio;
    private String image;

    public RealWorldUser2(RegisterUserRequest2 request) {
        this.username = request.getUsername();
        this.email = request.getEmail();
        this.password = request.getPassword();
    }
}
