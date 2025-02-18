package com.example.users_app.user_feature.infraestructure.entity;

import com.example.users_app.user_feature.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 25)
    private String name;
    @Column(name = "lastName", length = 25)
    private String lastName;
    @Column(name = "email", length = 25)
    private String email;
    @Column(name = "username", length = 25)
    private String username;
    @Column(name = "password")
    private String password;
}
