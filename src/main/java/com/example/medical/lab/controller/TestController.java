package com.example.medical.lab.controller;

import com.example.medical.lab.model.Test;
import com.example.medical.lab.repository.TestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tests")
public class TestController {

    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @PostMapping
    public Test addTest(@RequestBody Test test) {
        return testRepository.save(test);
    }

    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable int id) {
        testRepository.deleteById(id);
    }
}