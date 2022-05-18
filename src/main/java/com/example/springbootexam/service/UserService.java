package com.example.springbootexam.service;

import com.example.springbootexam.dto.UserDto;
import com.example.springbootexam.model.User;

import java.util.List;

public interface UserService {

    User add(UserDto userDto);
    User getById(Long id);
    List<User> getAllUsers();
    User updateUser(Long userId, UserDto user);
    void deleteUser(Long userId);

}
