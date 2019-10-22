package com.autohome.autoracing.controller;


import com.autohome.autoracing.Result;
import com.autohome.autoracing.component.PartsFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "主控制器")
@RestController
public class MainController {

    @Autowired
    private PartsFactory factory;

    @ApiOperation(value = "获取所有零件")
    @GetMapping("/parts")
    public Object getParts() {
        return Result.successResult(factory.getAllParts());
    }

    @ApiOperation(value = "获取单个零件")
    @GetMapping("/part/{type}/{id}")
    public Object getPart(@PathVariable String type, @PathVariable Integer id) {
        return Result.successResult(factory.getPart(type, id));
    }





    /*@Override
    public void afterPropertiesSet() throws Exception {
        serviceBeans.put("engine", engineService);
        serviceBeans.put("engine", engineService);
        serviceBeans.put("engine", engineService);
        serviceBeans.put("engine", engineService);
        serviceBeans.put("engine", engineService);
    }*/
}
