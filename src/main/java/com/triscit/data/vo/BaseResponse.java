package com.triscit.data.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/4 13:14
 */
@Schema(description = "返回参数")
public class BaseResponse<T> implements Serializable {

    public static<T> BaseResponse<T> ok (T t){
        BaseResponse<T> response = new BaseResponse<T>();
        response.setData(t);
        return response;
    }

    /** 响应状态码 */
    private Integer code;
    @Schema(description = "名称")
    private String message;
    /** 响应对象 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
