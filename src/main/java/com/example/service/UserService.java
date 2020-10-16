package com.example.service;

import com.example.entity.User;

import java.util.List;


public interface UserService {
    List<User> findAllByName(String name);

    void save(User user);

    void delete(User user);


    void deleteByName(String name);

}
