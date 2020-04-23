package com.xcl.security.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xcl.security.dto.User;
import com.xcl.security.dto.UserQueryCondition;
import com.xcl.security.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * UserConroller
 *
 * @author 徐长乐
 * @date 2020/4/20
 */
@RestController
@RequestMapping("/user")
public class UserConroller {

//    public List<User> query(@RequestParam(required = false,defaultValue = "test" ,name = "username") String nickname){
//        List<User> users = new ArrayList<>();
//        System.out.println(nickname);
//        users.add(new User());
//        users.add(new User());
//        users.add(new User());
//        return users;
//    }
    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails;
    }
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation("查询用户服务")
    public List<User> queryTest1(UserQueryCondition condition,@PageableDefault(page = 1,size = 15,sort = "username,asc") Pageable pageable){
        List<User> users = new ArrayList<>();
        System.out.println(ReflectionToStringBuilder.toString(condition,ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    @ApiOperation("查询单个用户服务")
    public User getInfo(@ApiParam("用户id") @PathVariable String id){
//        throw new UserNotExistException(id);
        User user = new User();
        user.setUsername("tom");
        return user;
    }
    @PostMapping
    @ApiOperation("创建用户")
    public User create(@Valid @RequestBody User user ){
//        if (errors.hasErrors()){
//            errors.getAllErrors().stream().forEach(error->System.out.println(error.getDefaultMessage()));
//        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }
    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user , BindingResult errors){
        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error-> {
//                FieldError fieldError = (FieldError) error;

                System.out.println(error.getDefaultMessage());

                    });
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }
    @DeleteMapping("{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }
}
