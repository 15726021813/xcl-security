package com.xcl.security.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcl.security.validator.MyContraint;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * User
 *
 * @author 徐长乐
 * @date 2020/4/20
 */
public class User {

    public interface UserSimpleView{};

    public interface UserDetailView extends UserSimpleView{}

    private String id;
    @MyContraint(message = "this is test")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Past(message = "生日必须为过去的时间")
    private Date birthday;



    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
