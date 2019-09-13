package com.springboot.dubbo.api.response;

import com.springboot.dubbo.api.enums.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WH
 * @version 1.0
 * @date 2019/9/5 21:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    //返回状态码
    private Integer code;
    //返回信息
    private String msg;
    //返回对象
    private T data;

    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }



}
