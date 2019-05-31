package com.api.service;

import com.api.bean.User;
import com.api.service.impl.FeginHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * feign中使用熔断，对于接口中的所有方法出现问题都可以熔断
 */
@FeignClient(value = "SERVER-PROVIDER-01", fallback = FeginHystrixServiceImpl.class)
public interface FeignHystrixService {

    @GetMapping("user/list")
    public List<User> findAll();

        @GetMapping("user/get/{id}")
    public User getUserById(@PathVariable("id") Integer id);

    @RequestMapping("/user/add")
    public Boolean add(User user);
}
