package com.example.users_app.user_feature.domain.model;

import com.example.users_app.user_feature.infraestructure.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public static UserEntity toEntity(){

        return new UserEntity(0L,"","","","","");
    }
}
