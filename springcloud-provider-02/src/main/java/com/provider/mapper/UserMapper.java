package com.provider.mapper;

import com.api.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 指定这是一个mapper接口
 */
@Mapper
public interface UserMapper {

    public List<User> findAll();

    public User getUserById(Integer id);

    public Boolean add(User user);


}
