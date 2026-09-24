package com.example.medical.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medical.lab.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}