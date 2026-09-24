package com.example.medical.lab.controller;

import com.example.medical.lab.model.Report;
import com.example.medical.lab.repository.ReportRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @GetMapping
    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    @PostMapping
    public Report addReport(@RequestBody Report report) {
        return reportRepository.save(report);
    }
}