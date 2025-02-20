package com.example.users_app.auth_feature.infraestructure.persistence;

import com.example.users_app.auth_feature.infraestructure.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
}
