package com.fegin.controller;

import com.api.bean.User;
import com.api.service.FeignHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 服务降级处理：
 *      当某个服务挂了，返回一些
 *
 *
 */
@RestController
@RequestMapping("/feign")
public class UserFeignHystrixController {

    @Autowired
    private FeignHystrixService serFeginService;

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("user/list")
    public List<User> findAll() {
        return serFeginService.findAll();
    }

    /*
    // 映射的接口参数和服务降级处理的方法参数一致
        返回类型也必须一致
     */
    @GetMapping("user/get/{id}")
    public User getUserById(@PathVariable("id") int id) {
        User user = serFeginService.getUserById(id);
        return user;
    }

    @RequestMapping("/user/add")
    public Boolean add(@RequestBody User user) {
        Boolean add = serFeginService.add(user);
        return add;
    }


}
