package com.sunb.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Created by sunb on 17-4-21.
 */
@Controller("modeler")
public class ModelerController {

    @Autowired
    RepositoryService repositoryService;

    public String create(@RequestParam("name") String name, @RequestParam("key") String key
            , @RequestParam(value = "description", required = false) String description) {


        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode modelObjectNode = objectMapper.createObjectNode();

        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, StringUtils.defaultString(description));

        Model newModel = repositoryService.newModel();
        newModel.setMetaInfo(modelObjectNode.toString());
        newModel.setName(name);
        newModel.setKey(StringUtils.defaultString(key));

        repositoryService.saveModel(newModel);

        ObjectNode editNode = objectMapper.createObjectNode();
        editNode.put("id", "canvas");
        editNode.put("resourceId", "canvas");

        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editNode.set("stencilset", stencilSetNode);

        try {
            repositoryService.addModelEditorSource(newModel.getId(), editNode.toString().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "redirect: /mservice/editor?id=" + newModel.getId();

    }
}
