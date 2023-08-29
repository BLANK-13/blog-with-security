package com.example.blogwithsecurity.Repository;

import com.example.blogwithsecurity.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

    User findUserById(Integer id);
}