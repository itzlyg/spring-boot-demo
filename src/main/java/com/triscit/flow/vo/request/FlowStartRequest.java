package com.triscit.flow.vo.request;


import jakarta.validation.constraints.NotNull;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/5 15:22
 */
public class FlowStartRequest {

    /** 流程类型 id */
    @NotNull(message = "流程类型不能爲空")
    private String flowId;

    /** 业务id */
    @NotNull(message = "业务id不能爲空")
    private String bsnId;
    /** 业务编号 用于显示 */
    private String bsnNo;
    /** 业务参数 */
    private FlowParamsRequest variables;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getBsnId() {
        return bsnId;
    }

    public void setBsnId(String bsnId) {
        this.bsnId = bsnId;
    }

    public String getBsnNo() {
        return bsnNo;
    }

    public void setBsnNo(String bsnNo) {
        this.bsnNo = bsnNo;
    }

    public FlowParamsRequest getVariables() {
        return variables;
    }

    public void setVariables(FlowParamsRequest variables) {
        this.variables = variables;
    }
}
