package com.example.springbootexam.service;

import com.example.springbootexam.dto.UserDto;
import com.example.springbootexam.model.User;
import com.example.springbootexam.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(UserDto userDto) {
        User user = User.builder()
                .first_name(userDto.getFirst_name())
                .second_name(userDto.getSecond_name())
                .login(userDto.getLogin())
                .passwordHash(userDto.getPassword())
                .email(userDto.getEmail())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            logger.warn("Юзер с id={} не найдена", id);
            throw new NoSuchElementException("Юзер с id=" + id + " не найдена");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, UserDto user) {
        User userUpdate = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        userUpdate.setFirst_name(user.getFirst_name());
        userUpdate.setSecond_name(user.getSecond_name());
        userRepository.save(userUpdate);
        return userUpdate;
    }

    @Override
    public void deleteUser(Long userId) {
        User userDelete = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(userDelete);
    }
}
