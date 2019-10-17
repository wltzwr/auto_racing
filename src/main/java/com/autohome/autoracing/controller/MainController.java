package com.autohome.autoracing.controller;


import com.autohome.autoracing.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    @Autowired
    private EngineService engineService;

    @GetMapping("/engines")
    public Object getEngines(){
        return engineService.selectList();
    }

}
