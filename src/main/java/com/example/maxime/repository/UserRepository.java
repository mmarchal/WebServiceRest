package com.example.maxime.repository;

import com.example.maxime.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value ="select * from user where email = :email" ,nativeQuery = true)
    User findByEmail(@Param(value = "email") String email);

    @Query(value = "SHOW TABLES", nativeQuery = true)
    List allNames();
}
