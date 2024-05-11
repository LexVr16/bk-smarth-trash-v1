package com.valros.ux.services.smartrash.models.dao;

import com.valros.ux.services.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserDao {

    User getUserById(String id);
    List<User> getAllUsers();
    User createUser(User user);
    ResponseEntity<Void> deleteUserById(String id);
    User updateUser(User user);
}
