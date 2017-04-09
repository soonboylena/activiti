package com.sunb.bpmn;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.HashMap;

import static org.junit.Assert.assertNotNull;

/**
 * Created by sunb on 17-4-9.
 */
public class processTest {

    private String filename = "/home/sunb/IdeaProjects/activiti/src/main/java/com/sunb/bpmn/process.bpmn";

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule();

    @Test
    public void startProcess() throws Exception {
        RepositoryService repositoryService = activitiRule.getRepositoryService();
        repositoryService.createDeployment().addInputStream("process.bpmn20.xml", new FileInputStream(filename)).deploy();

        RuntimeService runtimeService = activitiRule.getRuntimeService();
        HashMap<String, Object> map = new HashMap<String, Object>() {{
            put("name", "Activiti");
        }};

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave", map);
        assertNotNull(processInstance.getId());
        System.out.println(processInstance.getId() + ";" + processInstance.getProcessDefinitionId());

    }

}
