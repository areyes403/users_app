package com.example.users_app.user_feature.infraestructure.model.mapper;

import com.example.users_app.user_feature.domain.model.User;
import com.example.users_app.user_feature.infraestructure.entity.UserEntity;

public class UserMapper {
    public static UserEntity toUserEntity(User user) {
        return UserEntity
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .build();
    }

    public static User toUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .lastName(userEntity.getLastName())
                .username(userEntity.getUsername())
                .build();
    }
}
