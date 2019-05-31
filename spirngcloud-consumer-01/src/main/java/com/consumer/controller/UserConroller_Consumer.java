package com.consumer.controller;

import com.api.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserConroller_Consumer {


//    public static final String REST_URL = "http://localhost:8001";

    // 使用Ribbon负载均衡链接集群的服务，通过服务的名字取查找服务。
    public static final String REST_URL = "http://SERVER-PROVIDER-01";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/user/list")
    public List<User> findAll() {
        return restTemplate.getForObject(REST_URL + "/user/list", List.class);
    }

    @GetMapping("/consumer/user/get/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL + "/get/user/" + id, User.class);
    }


    @RequestMapping("/consumer/user/add")
    public Boolean add(User user) {
        return restTemplate.postForObject(REST_URL + "/user/add", user, Boolean.class);
    }


}
