package com.autohome.autoracing.controller;


import com.alibaba.fastjson.JSONObject;
import com.autohome.autoracing.Result;
import com.autohome.autoracing.component.PartsFactory;
import com.autohome.autoracing.model.Bodywork;
import com.autohome.autoracing.model.Engine;
import com.autohome.autoracing.model.Gearbox;
import com.autohome.autoracing.model.Wheel;
import com.autohome.autoracing.race.Car;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Api(value = "主控制器")
@RestController
public class MainController {
    private static final String CAR = "CAR";

    private static Set<String> nameTemp = Sets.newConcurrentHashSet();

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PartsFactory factory;

    @ApiOperation(value = "校验用户名重复")
    @GetMapping("/checkUsername")
    public Result checkUsername(@RequestParam String username) {
        if (nameTemp.contains(username)) {
            return Result.successResult(false);
        } else {
            nameTemp.add(username);
            return Result.successResult(true);
        }
    }

    @ApiOperation(value = "获取所有零件")
    @GetMapping("/parts")
    public Result getParts() {
        return Result.successResult(factory.getAllParts());
    }

    @ApiOperation(value = "获取单个零件")
    @GetMapping("/part/{type}/{id}")
    public Result getPart(@PathVariable String type, @PathVariable Integer id) {
        return Result.successResult(factory.getPart(type, id));
    }

    @ApiOperation(value = "组装")
    @PutMapping("/part/{type}/{id}")
    public Result assemble(@PathVariable String type, @PathVariable Integer id) {
        Car car = getCurrentCar();
        if (car == null) {
            car = new Car();
        }
        car.setPart(type, factory.getPart(type, id, getType(type)));
        setCurrentCar(car);
        return Result.successResult(car);
    }

    @ApiOperation(value = "测试")
    @PostMapping("/testCar")
    public Result testCar(@RequestBody JSONObject jsonCar) {
        final Car car = new Car();
        jsonCar.forEach((k, v) -> {
            Object part = factory.getPart(k, Integer.parseInt(v.toString()), getType(k));
            car.setPart(k, part);
        });
        setCurrentCar(car);
        return Result.successResult(car.test());
    }


    @ApiOperation(value = "加入比赛")
    @GetMapping("/join")
    public Result join() {
        return Result.successResult(null);
    }


    private Class<?> getType(String type) {
        switch (type) {
            case "wheel":
                return Wheel.class;
            case "bodywork":
                return Bodywork.class;
            case "gearbox":
                return Gearbox.class;
            case "engine":
                return Engine.class;
            default:
                return null;
        }
    }

    private Car getCurrentCar() {
        HttpSession session = request.getSession();
        return (Car) session.getAttribute(CAR);
    }

    private void setCurrentCar(Car car) {
        HttpSession session = request.getSession();
        session.setAttribute(CAR, car);
    }

}
