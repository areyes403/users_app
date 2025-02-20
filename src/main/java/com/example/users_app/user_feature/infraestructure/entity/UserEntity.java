package com.example.users_app.user_feature.infraestructure.entity;

import com.example.users_app.auth_feature.infraestructure.entity.Role;
import com.example.users_app.user_feature.domain.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
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

    @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","role_id"})}
    )
    private Set<Role> roles;

}
