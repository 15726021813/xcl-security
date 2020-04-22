package com.xcl.security.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * UserQueryCondition
 *
 * @author 徐长乐
 * @date 2020/4/20
 */
public class UserQueryCondition {
    @ApiModelProperty(value = "用户名称")
    private String username;
    @ApiModelProperty(value = "用户年龄起始值")
    private int age;
    @ApiModelProperty("用户年龄终止值")
    private int ageto;

    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeto() {
        return ageto;
    }

    public void setAgeto(int ageto) {
        this.ageto = ageto;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
}
