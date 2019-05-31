package com.provider.mapper;


import com.api.bean.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    public boolean addDept(Department dept);

    public Department findById(Long id);

    public List<Department> findAll();

}
