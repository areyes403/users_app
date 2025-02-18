package com.example.users_app.user_feature.infraestructure.persistence;

import com.example.users_app.user_feature.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
