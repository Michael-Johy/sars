package com.johnny.sars.http;

import lombok.Getter;

/**
 * * Created By: yangtao3
 * * Date: 2019/3/5 16:55
 * * Description: Response Code
 */
@Getter
public enum ResponseStatus {

    OK(200, "OK"),
    INVALID_PARAM(401, "请求参数错误"),
    AUTH_FAILED(402, "鉴权失败"),
    INNER_ERROR(501, "系统错误");

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
