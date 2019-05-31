package com.api.bean;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Department implements Serializable {

    private Long dId; // 主键
    private String dName; // 部门名称
    private String dbSource;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库



}
