package com.xcl.security.config;

import com.xcl.security.web.filter.TimeFilter;
import com.xcl.security.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.FilterRegistration;
import java.util.ArrayList;
import java.util.List;

/**
 * WebConfig
 *
 * @author 徐长乐
 * @date 2020/4/21
 */
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter {
      @Autowired
      private TimeInterceptor interceptor;

      @Override
      public  void addInterceptors(InterceptorRegistry registry){

//          registry.addInterceptor(interceptor);
      }

//      @Bean
      public FilterRegistrationBean timeFilter(){
          FilterRegistrationBean registrationBean = new FilterRegistrationBean();

          TimeFilter timeFilter = new TimeFilter();
          registrationBean.setFilter(timeFilter);
          List<String> urls = new ArrayList<>();
          urls.add("/*");
          registrationBean.setUrlPatterns(urls);
          return  registrationBean;
      }
}
