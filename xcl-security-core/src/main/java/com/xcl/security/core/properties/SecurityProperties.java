package com.xcl.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SecurityProperties
 *
 * @author 徐长乐
 * @date 2020/4/22
 */
@ConfigurationProperties(prefix = "xcl.security")
public class SecurityProperties {

  private   BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
