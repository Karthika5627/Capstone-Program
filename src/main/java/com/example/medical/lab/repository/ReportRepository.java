package com.example.medical.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medical.lab.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}