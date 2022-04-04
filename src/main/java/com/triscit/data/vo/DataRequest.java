package com.triscit.data.vo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/4 13:14
 */
@Schema(description = "请求参数")
public class DataRequest {

    @Schema(description = "名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
