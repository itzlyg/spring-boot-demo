package com.triscit.flow.vo.request;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/5 20:15
 */
public class FlowExamineRequest {

    private String taskId;

    /** 业务参数 */
    private FlowParamsRequest variables;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public FlowParamsRequest getVariables() {
        return variables;
    }

    public void setVariables(FlowParamsRequest variables) {
        this.variables = variables;
    }
}
