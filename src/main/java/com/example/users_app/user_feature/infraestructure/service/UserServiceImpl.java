package com.example.users_app.user_feature.infraestructure.service;

import com.example.users_app.user_feature.domain.model.User;
import com.example.users_app.user_feature.domain.service.UserService;
import com.example.users_app.user_feature.infraestructure.entity.UserEntity;
import com.example.users_app.user_feature.infraestructure.model.mapper.UserMapper;
import com.example.users_app.user_feature.infraestructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(
            UserRepository userRepository
    ){
        this.userRepository=userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(UserMapper::toUser);
    }

    @Override
    @Transactional
    public User create(User user) {
        UserEntity saved = userRepository.save(UserMapper.toUserEntity(user));
        return UserMapper.toUser(saved);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        userRepository.findAll();
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserMapper::toUser)
                .collect(Collectors.toList());
    }


}
