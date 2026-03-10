package com.example.UrbanCart.Mapper;

import com.example.UrbanCart.dto.UserRequestDTO;
import com.example.UrbanCart.dto.UserResponseDTO;
import com.example.UrbanCart.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {
    public User toUser(UserRequestDTO userRequestDTO){
         return new User(userRequestDTO.getName(), userRequestDTO.getEmail(), userRequestDTO.getPassword());
    }
    public  UserResponseDTO toUserResponse(User user){
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }



}
