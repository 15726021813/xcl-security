package com.xcl.security.core.properties;

import sun.dc.pr.PRError;

/**
 * BrowserProperties
 *
 * @author 徐长乐
 * @date 2020/4/22
 */
public class BrowserProperties {

    private String loginPage = "/signIn.html";

    private LoginType loginType = LoginType.JSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
