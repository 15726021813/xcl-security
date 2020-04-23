package com.xcl.security.core;

import com.xcl.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * SecurityCoreConfig
 *
 * @author 徐长乐
 * @date 2020/4/22
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
