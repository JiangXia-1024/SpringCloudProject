package com.jiangxia.demo02.service;

import com.jiangxia.demo02.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    User findOne(String id);
}
