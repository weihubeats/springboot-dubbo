package com.springboot.dubbo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wh
 * @version 1.0
 * @date 2019-9-2 16:10
 */
@Data
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private Integer password;


}
