package com.example.springbootdemo.service;

import com.example.springbootdemo.model.User;

import java.util.List;

public interface UserService {
    public User findBuId(int id);

    public List<User> findAll();

    public User saveUser(User user);

    public void deleteById(int id);

}
