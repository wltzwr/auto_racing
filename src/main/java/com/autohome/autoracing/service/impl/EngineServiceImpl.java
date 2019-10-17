package com.autohome.autoracing.service.impl;

import com.autohome.autoracing.mapper.EngineMapper;
import com.autohome.autoracing.pojo.Engine;
import com.autohome.autoracing.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineServiceImpl extends BaseServiceImpl<Engine> implements EngineService {
    @Autowired
    public EngineServiceImpl(EngineMapper bodyworkMapper) {
        super(bodyworkMapper);
    }
}