package com.example.users_app.user_feature.domain.service;


import com.example.users_app.user_feature.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    User save(User user);
    void delete(Long id);
    List<User> findAll();
}