package com.provider.service;

import com.api.bean.Department;

import java.util.List;

public interface DeparemtnetService {

    public boolean addDept(Department dept);

    public Department findById(Long id);

    public List<Department> findAll();
}
