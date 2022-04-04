package com.triscit.data.vo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/4 13:14
 */
@Schema(description = "返回参数")
public class DataResponse {

    @Schema(description = "名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
