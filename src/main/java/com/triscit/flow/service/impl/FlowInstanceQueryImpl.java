package com.triscit.flow.service.impl;

import com.triscit.flow.service.FlowInstanceQuery;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.runtime.ProcessInstanceQuery;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * 流程实例查询
 * @author xyb
 * @Description
 * @Date 2022/4/5 16:23
 */
@Service
public class FlowInstanceQueryImpl extends ServiceFactory implements FlowInstanceQuery {

    protected static Logger logger = LoggerFactory.getLogger(FlowInstanceQueryImpl.class);

    @Override
    public ProcessInstanceQuery createProcessInstanceQuery() {
        return runtimeService.createProcessInstanceQuery();
    }

    @Override
    public ProcessInstance processInstanceId(String processInstanceId) {
        return createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
    }

    @Override
    public ProcessInstance processInstanceBusinessKey(String processInstanceBusinessKey) {
        return createProcessInstanceQuery().processInstanceBusinessKey(processInstanceBusinessKey).singleResult();
    }

    @Override
    public boolean hasProcessInstanceFinished(String processInstanceId) {
        ProcessInstance pi = processInstanceId(processInstanceId);
        return pi == null;
    }

    @Override
    public ProcessInstance taskId(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstId = task.getProcessInstanceId();
        return this.processInstanceId(processInstId);
    }

}
