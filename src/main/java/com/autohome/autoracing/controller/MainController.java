package com.autohome.autoracing.controller;


import com.autohome.autoracing.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "主控制器")
@RestController
public class MainController implements ApplicationContextAware {

    private Map<String, BaseService> serviceBeans = new HashMap<>();

    @Autowired
    private EngineService engineService;
    @Autowired
    private GearboxService gearboxService;
    @Autowired
    private ShaftService shaftService;
    @Autowired
    private WheelService wheelService;
    @Autowired
    private BodyworkService bodyworkService;

    @ApiOperation(value = "获取所有零件")
    @GetMapping("/parts")
    public Object getParts(){
        Map<String, Object> parts = new HashMap<>();
        parts.put("engines", engineService.selectList());
        parts.put("gearboxes", gearboxService.selectList());
        parts.put("shafts", shaftService.selectList());
        parts.put("wheels", wheelService.selectList());
        parts.put("bodyworks", bodyworkService.selectList());
        return parts;
    }
    @ApiOperation(value = "获取单个零件")
    @GetMapping("/part/{type}/{id}")
    public Object getPart(@PathVariable String type, @PathVariable Integer id){
        return serviceBeans.get(type).select(id);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext.getBeansOfType(BaseService.class).forEach((k, v) -> {
            String key = k.substring(0, k.indexOf("Service"));
            serviceBeans.put(key, v);
        });
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
