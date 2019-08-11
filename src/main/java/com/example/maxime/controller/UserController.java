package com.example.maxime.controller;

import com.example.maxime.dto.UserDto;
import com.example.maxime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Collection<UserDto> getUsers(){
        return this.userService.getAll();
    }

    @PostMapping
    public boolean createUser(@RequestBody UserDto user){
        return this.userService.createUser(user);
    }

}
