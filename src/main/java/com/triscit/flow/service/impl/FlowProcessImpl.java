package com.triscit.flow.service.impl;

import com.triscit.flow.service.FlowProcess;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.repository.DeploymentQuery;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.repository.ProcessDefinitionQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;


/**
 * 流程定义
 * @author xyb
 * @Description
 * @Date 2022/4/5 15:43
 */
@Service
public class FlowProcessImpl extends ServiceFactory implements FlowProcess {

    protected static Logger logger = LoggerFactory.getLogger(FlowProcessImpl.class);

    public static final String BPMN_FILE_SUFFIX = ".bpmn";

    @Override
    public DeploymentBuilder createDeployment() {
        return repositoryService.createDeployment();
    }

    @Override
    public DeploymentQuery createDeploymentQuery() {
        return repositoryService.createDeploymentQuery();
    }

    @Override
    public ProcessDefinitionQuery createProcessDefinitionQuery() {
        return repositoryService.createProcessDefinitionQuery();
    }

    @Override
    public Deployment deploy(String bpmnFileUrl) {
        return createDeployment().addClasspathResource(bpmnFileUrl).deploy();
    }

    @Override
    public Deployment deploy(String url, String pngUrl) {
        return createDeployment().addClasspathResource(url).addClasspathResource(pngUrl).deploy();
    }

    @Override
    public Deployment deploy(String name, String tenantId, String category, ZipInputStream zipInputStream) {
        return createDeployment().addZipInputStream(zipInputStream)
                .name(name).category(category).tenantId(tenantId).deploy();
    }

    @Override
    public Deployment deployBpmnAndDrl(String url, String drlUrl) {
        return createDeployment().addClasspathResource(url).addClasspathResource(drlUrl).deploy();
    }

    @Override
    public Deployment deploy(String url, String name, String category) {
        return createDeployment().addClasspathResource(url).name(name).category(category).deploy();
    }

    @Override
    public Deployment deploy(String url, String pngUrl, String name, String category) {
        return createDeployment().addClasspathResource(url).addClasspathResource(pngUrl)
                .name(name).category(category).deploy();
    }

    @Override
    public boolean exist(String processDefinitionKey) {
        ProcessDefinitionQuery processDefinitionQuery
                = createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey);
        long count = processDefinitionQuery.count();
        return count > 0;
    }

    @Override
    public Deployment deploy(String name, String tenantId, String category, InputStream in) {
        return createDeployment().addInputStream(name + BPMN_FILE_SUFFIX, in)
                .name(name)
                .tenantId(tenantId)
                .category(category)
                .deploy();

    }

    @Override
    public ProcessDefinition queryByProcessDefinitionKey(String processDefinitionKey) {
        ProcessDefinition processDefinition
                = createProcessDefinitionQuery()
                .processDefinitionKey(processDefinitionKey)
                .active().singleResult();
        return processDefinition;
    }

    @Override
    public Deployment deployName(String deploymentName) {
        List<Deployment> list = repositoryService
                .createDeploymentQuery()
                .deploymentName(deploymentName).list();
        Assert.notNull(list, "list must not be null");
        return list.get(0);
    }

    @Override
    public void addCandidateStarterUser(String processDefinitionKey, String userId) {
        repositoryService.addCandidateStarterUser(processDefinitionKey, userId);
    }

}
