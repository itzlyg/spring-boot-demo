package com.triscit.flow.service;

import com.triscit.flow.vo.request.FlowExamineRequest;
import com.triscit.flow.vo.request.FlowStartRequest;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/5 15:20
 */
public interface FlowDataService {

    String start (FlowStartRequest startRequest);
    String examine(FlowExamineRequest request);
}
