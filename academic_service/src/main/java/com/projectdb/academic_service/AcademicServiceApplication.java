package com.projectdb.academic_service;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.projectdb.academic_service.repository.DepartmentRepository;
import com.projectdb.academic_service.model.Department;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan("com.projectdb.academic_service.model")
public class AcademicServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademicServiceApplication.class, args);
    }

    
}
