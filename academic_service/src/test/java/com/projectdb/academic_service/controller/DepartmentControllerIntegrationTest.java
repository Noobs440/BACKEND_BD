package com.projectdb.academic_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectdb.academic_service.dto.DepartmentDTO;
import com.projectdb.academic_service.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void cleanDatabase() {
        repository.deleteAll();  // on vide la base à chaque test
    }

    @Test
    void createDepartment_shouldReturnCreatedDepartment() throws Exception {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setName("Informatique");

        mockMvc.perform(post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.name", is("Informatique")));
    }

    @Test
    void getAllDepartments_shouldReturnList() throws Exception {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setName("Génie Civil");
        repository.save(new com.projectdb.academic_service.model.Department(dto.getName()));

        mockMvc.perform(get("/api/departments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Génie Civil")));
    }
}
