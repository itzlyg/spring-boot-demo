package com.triscit.flow.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author xyb
 * @Description
 * @Date 2022/4/5 15:51
 */
@Schema(description = "任务vo")
public class TaskVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String owner;
    private Integer assigneeUpdatedCount;
    private String originalAssignee;
    private String assignee;
    private String parentTaskId;
    private String name;
    private String localizedName;
    private String description;
    private String localizedDescription;
    private Integer priority;
    private Date createTime;
    private Date dueDate;
    private Integer suspensionState;
    private String category;
    private Boolean isIdentityLinksInitialized;
    private String executionId;
    private String processInstanceId;
    private String processDefinitionId;
    private String taskDefinitionId;
    private String scopeId;
    private String subScopeId;
    private String scopeType;
    private String scopeDefinitionId;
    private String taskDefinitionKey;
    private String formKey;
    private Boolean isCanceled;
    private Boolean isCountEnabled;
    private Integer variableCount;
    private Integer identityLinkCount;
    private Integer subTaskCount;
    private Date claimTime;
    private String tenantId;
    private String eventName;
    private String eventHandlerId;
    private String idPrefix;
    private Boolean forcedUpdate;
    private Boolean isInserted;
    private Boolean isUpdated;
    private Boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getAssigneeUpdatedCount() {
        return assigneeUpdatedCount;
    }

    public void setAssigneeUpdatedCount(Integer assigneeUpdatedCount) {
        this.assigneeUpdatedCount = assigneeUpdatedCount;
    }

    public String getOriginalAssignee() {
        return originalAssignee;
    }

    public void setOriginalAssignee(String originalAssignee) {
        this.originalAssignee = originalAssignee;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalizedDescription() {
        return localizedDescription;
    }

    public void setLocalizedDescription(String localizedDescription) {
        this.localizedDescription = localizedDescription;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIdentityLinksInitialized() {
        return isIdentityLinksInitialized;
    }

    public void setIdentityLinksInitialized(Boolean identityLinksInitialized) {
        isIdentityLinksInitialized = identityLinksInitialized;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getTaskDefinitionId() {
        return taskDefinitionId;
    }

    public void setTaskDefinitionId(String taskDefinitionId) {
        this.taskDefinitionId = taskDefinitionId;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public String getSubScopeId() {
        return subScopeId;
    }

    public void setSubScopeId(String subScopeId) {
        this.subScopeId = subScopeId;
    }

    public String getScopeType() {
        return scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public String getScopeDefinitionId() {
        return scopeDefinitionId;
    }

    public void setScopeDefinitionId(String scopeDefinitionId) {
        this.scopeDefinitionId = scopeDefinitionId;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public Boolean getCanceled() {
        return isCanceled;
    }

    public void setCanceled(Boolean canceled) {
        isCanceled = canceled;
    }

    public Boolean getCountEnabled() {
        return isCountEnabled;
    }

    public void setCountEnabled(Boolean countEnabled) {
        isCountEnabled = countEnabled;
    }

    public Integer getVariableCount() {
        return variableCount;
    }

    public void setVariableCount(Integer variableCount) {
        this.variableCount = variableCount;
    }

    public Integer getIdentityLinkCount() {
        return identityLinkCount;
    }

    public void setIdentityLinkCount(Integer identityLinkCount) {
        this.identityLinkCount = identityLinkCount;
    }

    public Integer getSubTaskCount() {
        return subTaskCount;
    }

    public void setSubTaskCount(Integer subTaskCount) {
        this.subTaskCount = subTaskCount;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventHandlerId() {
        return eventHandlerId;
    }

    public void setEventHandlerId(String eventHandlerId) {
        this.eventHandlerId = eventHandlerId;
    }

    public String getIdPrefix() {
        return idPrefix;
    }

    public void setIdPrefix(String idPrefix) {
        this.idPrefix = idPrefix;
    }

    public Boolean getForcedUpdate() {
        return forcedUpdate;
    }

    public void setForcedUpdate(Boolean forcedUpdate) {
        this.forcedUpdate = forcedUpdate;
    }

    public Boolean getInserted() {
        return isInserted;
    }

    public void setInserted(Boolean inserted) {
        isInserted = inserted;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public void setUpdated(Boolean updated) {
        isUpdated = updated;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}