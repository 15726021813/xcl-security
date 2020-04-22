package com.xcl.security.dto;

/**
 * FileInfo
 *
 * @author 徐长乐
 * @date 2020/4/21
 */
public class FileInfo {


    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
