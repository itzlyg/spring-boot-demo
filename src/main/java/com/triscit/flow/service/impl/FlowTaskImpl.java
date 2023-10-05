package com.triscit.flow.service.impl;

import com.triscit.flow.service.FlowTask;
import com.triscit.flow.service.FlowTaskQuery;
import com.triscit.flow.vo.TaskVo;
import com.triscit.util.PojoUtil;
import jakarta.annotation.Resource;
import org.flowable.engine.task.Comment;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程任务
 * @author xyb
 * @Description
 * @Date 2022/4/5 15:43
 */
@Service
public class FlowTaskImpl extends ServiceFactory implements FlowTask {

    @Resource
    private FlowTaskQuery flowTaskQuery;

    protected static Logger logger = LoggerFactory.getLogger(FlowTaskImpl.class);

    @Override
    public void claim(String taskId, String userId) {
        taskService.claim(taskId, userId);
    }

    @Override
    public void unclaim(String taskId) {
        taskService.unclaim(taskId);
    }

    @Override
    public void complete(String taskId) {
        this.complete(taskId, null);
        logger.info("-----------任务ID：{},已完成-----------", taskId);
    }

    @Override
    public void complete(String taskId, Map<String, Object> variables) {
        taskService.complete(taskId, variables);
    }

    @Override
    public Map<String, Object> complete(String taskId, Map<String, Object> variables, boolean localScope) {
        TaskVo finishTask = flowTaskQuery.queryTaskVOById(taskId);
        taskService.complete(taskId, variables, localScope);
        Task task = flowTaskQuery.processInstanceId(finishTask.getProcessInstanceId());
        TaskVo activeTask = PojoUtil.copyBean(task, TaskVo.class);
        Map<String, Object> map = new HashMap<>(16);
        map.put("finish", finishTask);
        map.put("active", activeTask);
        return map;
    }

    @Override
    public void delegate(String taskId, String userId) {
        taskService.delegateTask(taskId, userId);
    }


    @Override
    public void resolveTask(String taskId) {
        taskService.resolveTask(taskId);
    }


    @Override
    public void setAssignee(String taskId, String userId) {
        taskService.setAssignee(taskId, userId);
    }

    @Override
    public void setOwner(String taskId, String userId) {
        taskService.setOwner(taskId, userId);
    }

    @Override
    public void delete(String taskId) {
        taskService.deleteTask(taskId);
    }

    @Override
    public void deleteWithReason(String taskId, String reason) {
        taskService.deleteTask(taskId, reason);
    }

    @Override
    public void addCandidateUser(String taskId, String userId) {
        taskService.addCandidateUser(taskId, userId);
    }

    @Override
    public Comment addComment(String taskId, String processInstanceId, String message) {
        return taskService.addComment(taskId, processInstanceId, message);
    }

    @Override
    public List<Comment> getTaskComments(String taskId) {
        return taskService.getTaskComments(taskId);
    }

    @Override
    public void withdraw(String processInstanceId, String currentActivityId, String newActivityId) {
        runtimeService.createChangeActivityStateBuilder()
                .processInstanceId(processInstanceId)
                .moveActivityIdTo(currentActivityId, newActivityId)
                .changeState();
    }

    @Override
    public void setVariableLocal(String taskId, String variableName, Object value) {
        taskService.setVariableLocal(taskId, variableName, value);
    }

    @Override
    public void setVariablesLocal(String taskId, Map<String, ? extends Object> variables) {
        taskService.setVariablesLocal(taskId, variables);
    }

}
