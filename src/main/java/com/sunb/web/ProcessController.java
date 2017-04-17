package com.sunb.web;

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

    @GetMapping("postList")
    public boolean listProcess() {
        return repositoryService == null;
    }

}
