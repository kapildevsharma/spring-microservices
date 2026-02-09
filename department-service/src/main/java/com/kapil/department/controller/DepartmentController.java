package com.kapil.department.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.department.entity.Department;
import com.kapil.department.service.DepartmentService;

@RestController
@Tag(name = "Department APIs", description = "Operations related to Department Management")
@RequestMapping("/departments")

public class DepartmentController {

	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    @Operation(summary = "Save Department", description = "Create a new department in the system")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Department by department id" , description = "Get department details by department id")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }
    
    @GetMapping("/")
    @Operation(summary = "Get all Departments" , description = "Get list of all departments in the system")
    public List<Department> getDepartmentlist() {
        log.info("Inside all Departments of DepartmentController");
        return departmentService.getDepartmentList();
    }

}
