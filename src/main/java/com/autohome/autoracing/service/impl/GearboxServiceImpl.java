package com.autohome.autoracing.service.impl;

import com.autohome.autoracing.mapper.GearboxMapper;
import com.autohome.autoracing.pojo.Gearbox;
import com.autohome.autoracing.service.GearboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GearboxServiceImpl extends BaseServiceImpl<Gearbox> implements GearboxService {
    @Autowired
    public GearboxServiceImpl(GearboxMapper bodyworkMapper) {
        super(bodyworkMapper);
    }
}