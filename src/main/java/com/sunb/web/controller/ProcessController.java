package com.sunb.web.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunb on 17-4-15.
 */
@RestController
public class ProcessController {

    @Autowired
    private ProcessEngineConfiguration repositoryService;

    @Autowired
    private ProcessEngine engine;

    @GetMapping("postList")
    public String listProcess() {
        System.out.println(engine);
        return repositoryService.getProcessEngineName();
    }

}
