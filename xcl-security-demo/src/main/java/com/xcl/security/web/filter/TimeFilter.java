package com.xcl.security.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * TimeFilter
 *
 * @author 徐长乐
 * @date 2020/4/21
 */
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Time Filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Time Filter start");
        long strat = System.currentTimeMillis();
        chain.doFilter(request,response);
        System.out.println("Time filter 耗时"+(System.currentTimeMillis()-strat));
        System.out.println("time filter end");
    }

    @Override
    public void destroy() {
        System.out.println("Time Filter destroy");

    }
}
