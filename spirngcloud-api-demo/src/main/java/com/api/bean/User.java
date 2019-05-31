package com.api.bean;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private Integer age;
    private String datasource;
    private String dept;
}
