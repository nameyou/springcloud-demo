package com.api.service;


import com.api.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 测试feign
 */
@FeignClient("SERVER-PROVIDER-01")  // 服务提供者的名字
public interface UserFeginService {

    @GetMapping("/user/list")
    public List<User> findAll();

    @GetMapping("/get/user/{id}")
    public User getUserById(@PathVariable("id") int id);

    @RequestMapping("/user/add")
    public Boolean add(@RequestBody User user);
}
