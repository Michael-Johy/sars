package com.johnny.utils.http;

import com.johnny.utils.lang.string.Strings;

/**
 * * Created By: yangtao3
 * * Date: 2019/3/5 16:41
 * * Description: Http uniform Response
 */
public class Response<T> {
    private Response() {
    }

    private int code = ResponseStatus.OK.getCode();
    private T data;
    private String message = ResponseStatus.OK.getMessage();

    public static <T> Response<T> buildSuccessResponse(T data) {
        return buildSuccessResponse(data, null);
    }

    public static <T> Response<T> buildSuccessResponse(T data, String message) {
        return buildResponse(ResponseStatus.OK, data, message);
    }

    public static <T> Response<T> buildInvalidParamResponse(String message) {
        return buildResponse(ResponseStatus.INVALID_PARAM, null, message);
    }

    public static <T> Response<T> buildInnerError(String message) {
        return buildResponse(ResponseStatus.INNER_ERROR, null, message);
    }

    public static <T> Response<T> buildAuthFailed(String message) {
        return buildResponse(ResponseStatus.AUTH_FAILED, null, message);
    }

    public static <T> Response<T> buildResponse(ResponseStatus responseStatus, T data, String message) {
        Response<T> response = new Response<>();
        response.setCode(responseStatus.getCode());
        response.setData(data);
        response.setMessage(Strings.isBlank(message) ? responseStatus.getMessage() : message);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

