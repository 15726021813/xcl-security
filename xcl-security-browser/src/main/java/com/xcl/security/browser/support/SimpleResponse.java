package com.xcl.security.browser.support;

/**
 * SimpleResponse
 *
 * @author 徐长乐
 * @date 2020/4/22
 */
public class SimpleResponse {

    private Object conent;

    public SimpleResponse(Object conent) {
        this.conent = conent;
    }

    public Object getConent() {
        return conent;
    }

    public void setConent(Object conent) {
        this.conent = conent;
    }
}
