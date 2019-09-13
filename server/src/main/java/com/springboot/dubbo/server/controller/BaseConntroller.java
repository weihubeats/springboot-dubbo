package com.springboot.dubbo.server.controller;

import com.springboot.dubbo.api.enums.StatusCode;
import com.springboot.dubbo.api.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WH
 * @version 1.0
 * @date 2019/9/5 21:50
 */
@Slf4j
@Controller
public class BaseConntroller {
    private static final String prefix = "base";


    @RequestMapping(value = prefix + "/one", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse one() {
        BaseResponse response = new BaseResponse(StatusCode.Success);

        return response;
    }
}
