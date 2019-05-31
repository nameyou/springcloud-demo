package com.fegin.controller;


import com.api.bean.User;
import com.api.service.UserFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试feign
 */

@RestController
public class UserFeignController {


    /**
     * 注入feign的接口
     */
    @Autowired
    private UserFeginService feginService;


    @GetMapping("/consumer/user/list")
    public List<User> findAll() {
        return feginService.findAll();
    }

    @GetMapping("/consumer/user/get/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return feginService.getUserById(id);
    }


    @RequestMapping("/consumer/user/add")
    public Boolean add(User user) {
        return feginService.add(user);
    }

}
