package com.kapil.user.client;

import com.kapil.user.VO.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "API-GATEWAY")
public interface DepartmentClient {

    @GetMapping("/departments/{id}")
    Department getDepartmentById(@PathVariable("id") Long id);
}



