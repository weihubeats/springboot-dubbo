package com.springboot.dubbo.model.dao;

import com.springboot.dubbo.model.entity.User;

import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2019/9/13 19:49
 */
public interface UserDao {

    List<User> findUser();
}
