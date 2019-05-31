package com.provider.controller;

import com.api.bean.User;
import com.provider.mapper.UserMapper;
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

    @GetMapping("/get/user/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userMapper.getUserById(id);
    }

    @RequestMapping("/user/add")
    public Boolean add(@RequestBody User user) {
        Boolean add = userMapper.add(user);
        return add;
    }

    @Autowired
	private DiscoveryClient client;
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }


}
