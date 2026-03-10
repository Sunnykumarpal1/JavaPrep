package com.example.UrbanCart.service;

import com.example.UrbanCart.entity.User;
import com.example.UrbanCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        try{
            userRepository.save(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    @Modifying
    public void deleteUser(String email) {
          userRepository.deleteByEmail(email);
    }
}
