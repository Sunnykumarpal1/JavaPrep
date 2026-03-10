package com.example.UrbanCart.controller;

import com.example.UrbanCart.Mapper.UserMapping;
import com.example.UrbanCart.dto.UserRequestDTO;
import com.example.UrbanCart.dto.UserResponseDTO;
import com.example.UrbanCart.entity.User;
import com.example.UrbanCart.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
//    @Autowired
    private final UserService userService;

//    @Autowired
    private final  UserMapping userMapping;


    public UserController(UserService userService, UserMapping userMapping) {
        this.userService = userService;
        this.userMapping = userMapping;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        User user = userMapping.toUser(userRequestDTO);
        userService.registerUser(user);
        UserResponseDTO userResponseDTO = userMapping.toUserResponse(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @GetMapping("/{email}")
   public ResponseEntity<UserResponseDTO>getUserByEmail(@PathVariable(name = "email") String email){
        User userByEmail = userService.getUserByEmail(email);
        UserResponseDTO userResponse = userMapping.toUserResponse(userByEmail);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>>getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        List<UserResponseDTO> users = allUsers.stream().map(userMapping::toUserResponse).toList();
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/{email:.+}")
    public ResponseEntity<Void>deleteUser(@PathVariable  String email){
       userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
