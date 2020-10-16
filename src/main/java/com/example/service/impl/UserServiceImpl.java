package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByName(String name) {
        userRepository.delete(userRepository.findByName(name));
       // throw new RuntimeException("错误信息"+System.currentTimeMillis());
    }

}
