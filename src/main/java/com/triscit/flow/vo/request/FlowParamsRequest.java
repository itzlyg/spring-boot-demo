package com.triscit.flow.vo.request;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/5 15:24
 */
public class FlowParamsRequest {

    private String params;

    /** 用戶id */
    private String userId;

    /** 審批是否通過 **/
    private boolean approved;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
