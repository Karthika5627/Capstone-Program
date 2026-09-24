package com.example.medical.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medical.lab.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

}