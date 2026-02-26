package com.kapil.department.service;

import com.kapil.department.entity.Department;
import com.kapil.department.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Find Department By Department Id of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> getDepartmentList() {
        log.info("Get Departments of DepartmentService");
        return departmentRepository.findAll();
    }

    public void deleteDepartmentById(Long departmentId) {
        log.info("Delete Department ById of DepartmentService");
        departmentRepository.deleteById(departmentId);
    }
}
