package com.api.service.impl;

import com.api.bean.User;
import com.api.service.FeignHystrixService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 在feign中使用短路器
 * 服务降级处理，暂时关闭某个服务时，提供
 */
@Component
public class FeginHystrixServiceImpl implements FeignHystrixService {


    @Override
    public List<User> findAll() {
        User user = new User();
        user.setUsername("對不起查詢的數據不存在！！！");
        List<User> users = Arrays.asList();
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setUsername("對不起查詢的數據不存在！！！");
        return user;
    }

    @Override
    public Boolean add(User user) {
        return true;
    }
}
