package com.triscit.flow.service.impl;

import com.triscit.flow.service.FlowDataService;
import com.triscit.flow.service.FlowInstance;
import com.triscit.flow.service.FlowTaskQuery;
import com.triscit.flow.vo.request.FlowExamineRequest;
import com.triscit.flow.vo.request.FlowParamsRequest;
import com.triscit.flow.vo.request.FlowStartRequest;
import com.triscit.flow.vo.request.FlowSubmitRequest;
import com.triscit.util.JsonUtil;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xyb
 * @Description
 * @Date 2022/4/5 15:20
 */
@Service
public class FlowDataServiceImpl extends ServiceFactory implements FlowDataService  {

    @Resource
    private FlowInstance flowInstance;

    @Resource
    private FlowTaskQuery flowTaskQuery;

    @Override
    public String start (FlowStartRequest startRequest){
        Map<String, Object> variablesMap = toMap(startRequest.getVariables());
        ProcessInstance pi = flowInstance.startProcessInstanceByKey(
                startRequest.getFlowId(),
                startRequest.getBsnId(),
                variablesMap
        );
        String processId = pi.getId();
        String name = pi.getName();
        return processId + "_" + name;
    }

    @Override
    public String examine(FlowExamineRequest request){
        String taskId = StringUtils.trimToEmpty(request.getTaskId());
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            return "流程不存在";
        }
        //通过
        Map<String, Object> variablesMap = toMap(request.getVariables());
        taskService.complete(taskId, variablesMap);
        return StringUtils.EMPTY;
    }

    public void submit(FlowSubmitRequest submitRequest){
        // query by db
        String processId = "";
        Task task = flowTaskQuery.processInstanceId(processId);
        Map<String, Object> variablesMap = toMap(submitRequest.getVariables());
        Map<String, Object> par = new HashMap<>();
        par.put("approveMsg", "发起申请");
        taskService.setVariablesLocal(task.getId(), par);
        taskService.complete(task.getId(), variablesMap, false);
    }

    private Map<String, Object> toMap (FlowParamsRequest params){
        Map<String, Object> variablesMap = null;
        if (params != null) {
            String json = JsonUtil.toJson(params);
            variablesMap = JsonUtil.toPojo(json, Map.class);
        }
        if (variablesMap == null) {
            variablesMap = new HashMap<>();
        }
        return variablesMap;
    }
}
