package com.xcl.security.service.impl;

import com.xcl.security.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl
 *
 * @author 徐长乐
 * @date 2020/4/21
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello"+name;
    }
}
