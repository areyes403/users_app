package com.example.users_app.auth_feature.infraestructure.service;

import com.example.users_app.user_feature.infraestructure.entity.UserEntity;
import com.example.users_app.user_feature.infraestructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> opUser = userRepository.findByUsername(username);
        if (opUser.isEmpty()){
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema",username));
        }

        UserEntity entity=opUser.orElseThrow();
        List<GrantedAuthority> auth=entity.getRoles()
                .stream()
                .map(role-> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new User(
                username,
                entity.getPassword(),
                true,
                true,
                true,
                true,
                auth);
    }
}
