package com.springboot.dubbo.api.server.impl;

import com.springboot.dubbo.api.server.UserService;
import com.springboot.dubbo.model.dao.UserDao;
import com.springboot.dubbo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2019/9/13 18:42
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;




    @Override
    public List<User> findUser() {
        return userDao.findUser();
    }
}
