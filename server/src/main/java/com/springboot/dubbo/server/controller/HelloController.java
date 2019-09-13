package com.springboot.dubbo.server.controller;

import com.springboot.dubbo.api.response.BaseResponse;
import com.springboot.dubbo.api.server.UserService;
import com.springboot.dubbo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wh
 * @version 1.0
 * @date 2019-9-2 16:08
 */
@Controller
@RequestMapping("user")
public class HelloController {


    @Autowired
    private UserService userService;



    @RequestMapping("/printUser")
    @ResponseBody
    public BaseResponse printUser(User user) {
        List<User> users = userService.findUser();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(users);
        return baseResponse;
    }
}
