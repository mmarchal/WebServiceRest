package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.UserDto;
import com.example.maxime.entities.User;
import com.example.maxime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service(value = "userService")
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    GenericConverter<User, UserDto> userConverter;

    @Override
    public UserDetails loadUserByUsername(final String mail) throws UsernameNotFoundException {
        User user = this.userRepo.findByEmail(mail);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password !");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), this.getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public Collection<UserDto> getAll() {
        return userConverter.entitiesToDtos(this.userRepo.findAll(),UserDto.class);
    }

    public boolean createUser(UserDto user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(null);
        this.userRepo.save(this.userConverter.dtoToEntity(user,User.class));
        return true;
    }
}
