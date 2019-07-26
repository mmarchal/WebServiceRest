package com.example.maxime.controller;

import com.example.maxime.entities.User;
import com.example.maxime.repository.UserRepository;
import com.example.maxime.security.config.JwtTokenUtil;
import com.example.maxime.security.model.ApiResponse;
import com.example.maxime.security.model.AuthToken;
import com.example.maxime.security.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public ApiResponse<AuthToken> register(@RequestBody LoginUser user) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        User userFromBase = userRepository.findByEmail(user.getUsername());
        String token = jwtTokenUtil.generateToken(userFromBase.getEmail());
        return new ApiResponse<>(200,"success",new AuthToken(token,userFromBase.getEmail(),userFromBase.getId()));
    }

}
