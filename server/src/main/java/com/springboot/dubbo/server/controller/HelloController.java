package com.springboot.dubbo.server.controller;

import com.springboot.dubbo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wh
 * @version 1.0
 * @date 2019-9-2 16:08
 */
@Controller
@RequestMapping("user")
public class HelloController {



    @RequestMapping("/printUser")
    @ResponseBody
    public User printUser(User user) {

        return user;
    }
}
