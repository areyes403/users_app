package com.example.users_app.user_feature.domain.model;

import com.example.users_app.user_feature.infraestructure.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
