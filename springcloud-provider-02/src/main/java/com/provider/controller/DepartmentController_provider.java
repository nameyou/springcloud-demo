package com.provider.controller;


import com.api.bean.Department;
import com.provider.mapper.DepartmentMapper;
import com.provider.service.DeparemtnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController_provider {

    @Autowired
    private DeparemtnetService deparemtnetService;

    @Autowired
    DepartmentMapper departmentMapper;


    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Department dept) {
        return deparemtnetService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Department findById(@PathVariable("id") Long id) {
        Department byId = departmentMapper.findById(id);
        return byId;
    }

    @GetMapping("/dept/list")
    public List<Department> findAll() {
        List<Department> all = departmentMapper.findAll();
        return all;
    }

}
