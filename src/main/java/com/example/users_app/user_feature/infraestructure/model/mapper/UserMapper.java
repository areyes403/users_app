package com.example.users_app.user_feature.infraestructure.model.mapper;

import com.example.users_app.user_feature.domain.model.User;
import com.example.users_app.user_feature.infraestructure.entity.UserEntity;

public class UserMapper {
    public static UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword()
        );
    }

    public static User toUser(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getUsername(),
                userEntity.getPassword()
        );
    }
}
