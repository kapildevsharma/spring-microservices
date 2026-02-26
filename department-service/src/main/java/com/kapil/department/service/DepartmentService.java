package com.kapil.department.service;

import java.util.List;
import com.kapil.department.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department findDepartmentById(Long departmentId) ;
    List<Department> getDepartmentList() ;
    void deleteDepartmentById(Long departmentId) ;
}
