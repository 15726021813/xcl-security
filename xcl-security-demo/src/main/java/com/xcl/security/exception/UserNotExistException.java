package com.xcl.security.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * UserNotExistException
 *
 * @author 徐长乐
 * @date 2020/4/21
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(String id){
        super("user not exist");
        this.id = id;
    }
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
