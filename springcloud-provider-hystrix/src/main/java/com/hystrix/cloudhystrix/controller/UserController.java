package com.hystrix.cloudhystrix.controller;

import com.api.bean.User;
import com.hystrix.cloudhystrix.mapper.UserMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/user/list")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /*
    // 映射的接口参数和服务降级处理的方法参数一致
        返回类型也必须一致
     */
    @GetMapping("user/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixErrors")
    public User getUserById(@PathVariable("id") int id) {
        User user = userMapper.getUserById(id);
        if (user == null) {
            throw new RuntimeException("数据不存在！！");
        }
        return user;
    }

    @RequestMapping("/user/add")
    public Boolean add(@RequestBody User user) {
        Boolean add = userMapper.add(user);
        return add;
    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("SERVER-PROVIDER-01");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }


    /**
     * 熔断回调
     */
    public User hystrixErrors(@PathVariable("id") int id) {
        User user = new User();
        user.setUsername("断路器");
        user.setDatasource("数据源");
        return user;
    }

}
