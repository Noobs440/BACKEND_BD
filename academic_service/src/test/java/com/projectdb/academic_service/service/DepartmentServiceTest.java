package com.projectdb.academic_service.service;

import com.projectdb.academic_service.dto.DepartmentDTO;
import com.projectdb.academic_service.exception.DepartmentAlreadyExistsException;
import com.projectdb.academic_service.model.Department;
import com.projectdb.academic_service.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDepartment_shouldCreateSuccessfully() {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setName("Informatique");

        when(departmentRepository.findByName("Informatique")).thenReturn(Optional.empty());
        when(departmentRepository.save(any(Department.class))).thenAnswer(invocation -> {
            Department dep = invocation.getArgument(0);
            dep.setId(1L);
            return dep;
        });

        Department result = departmentService.createDepartment(dto);

        assertNotNull(result);
        assertEquals("Informatique", result.getName());
        assertEquals(1L, result.getId());
    }

    @Test
    void createDepartment_shouldThrowExceptionIfExists() {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setName("Mathématiques");

        Department existing = new Department();
        existing.setId(2L);
        existing.setName("Mathématiques");

        when(departmentRepository.findByName("Mathématiques")).thenReturn(Optional.of(existing));

        assertThrows(DepartmentAlreadyExistsException.class, () -> {
            departmentService.createDepartment(dto);
        });

        verify(departmentRepository, never()).save(any());
    }
}
