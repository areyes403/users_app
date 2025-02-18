package com.example.users_app.user_feature.domain.service;


import com.example.users_app.user_feature.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    User create(User user);
    void delete(Long id);
    List<User> findAll();
}