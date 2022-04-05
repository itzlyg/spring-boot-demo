package com.triscit.flow.vo.request;


import jakarta.validation.constraints.NotNull;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/5 15:22
 */
public class FlowSubmitRequest {

    /** 流审批id id */
    @NotNull(message = "审批id不能爲空")
    private String approveId;

    /** 业务参数 */
    private FlowParamsRequest variables;

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId;
    }

    public FlowParamsRequest getVariables() {
        return variables;
    }

    public void setVariables(FlowParamsRequest variables) {
        this.variables = variables;
    }
}
