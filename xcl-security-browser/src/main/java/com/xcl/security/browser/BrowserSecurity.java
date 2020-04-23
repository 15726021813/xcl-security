package com.xcl.security.browser;

import com.xcl.security.browser.authentication.XclAuthenticationFailureHandler;
import com.xcl.security.browser.authentication.XclAuthenticationSuccessHandler;
import com.xcl.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * BrowserSecurity
 *
 * @author 徐长乐
 * @date 2020/4/22
 */
@Configuration
public class BrowserSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    XclAuthenticationSuccessHandler xclAuthenticationSuccessHandler;

    @Autowired
    XclAuthenticationFailureHandler xclAuthenticationFailureHandler;
    /**
     * 密码加密
      * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(xclAuthenticationSuccessHandler)
                .failureHandler(xclAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
