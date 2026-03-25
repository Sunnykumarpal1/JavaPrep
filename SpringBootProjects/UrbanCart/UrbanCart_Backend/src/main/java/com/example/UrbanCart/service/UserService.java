package com.example.UrbanCart.service;

import com.example.UrbanCart.Exception.UserAlreadyExistsException;
import com.example.UrbanCart.entity.User;
import com.example.UrbanCart.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    public void deleteUser(String email) {
          userRepository.deleteByEmail(email);
    }
}
