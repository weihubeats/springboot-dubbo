package com.springboot.dubbo.api.server;

import com.springboot.dubbo.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2019/9/13 18:06
 */
public interface UserService {

    List<User> findUser();
}
