package com.springboot.dubbo.model.entity;

/**
 * @author wh
 * @version 1.0
 * @date 2019-9-2 16:10
 */
public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
