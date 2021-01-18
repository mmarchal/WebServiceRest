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
    private UserService userService;

    @GetMapping
    public Collection<UserDto> getUsers(){
        return this.userService.getAll();
    }

    @PostMapping
    public boolean createUser(@RequestBody UserDto user){
        return this.userService.createUser(user);
    }

    @GetMapping("/database")
    public List getAllDatabasesNames() {
        return this.userService.databasesNames();
    }

    @PostMapping("/synchroData")
    public boolean synchroData() {
        try {
            this.userService.synchro();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
