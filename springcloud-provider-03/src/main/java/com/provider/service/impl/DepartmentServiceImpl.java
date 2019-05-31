package com.provider.service.impl;


import com.api.bean.Department;
import com.provider.mapper.DepartmentMapper;
import com.provider.service.DeparemtnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DeparemtnetService {


    @Autowired
    private DepartmentMapper departmentMapper;

    public boolean addDept(Department dept) {
        return departmentMapper.addDept(dept);
    }

    public Department findById(Long id) {

        Department byId = departmentMapper.findById(id);
        return byId;
    }

    public List<Department> findAll() {
        List<Department> all = departmentMapper.findAll();
        return all;
    }
}
