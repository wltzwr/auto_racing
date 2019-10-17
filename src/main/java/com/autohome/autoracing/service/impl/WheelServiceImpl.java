package com.autohome.autoracing.service.impl;

import com.autohome.autoracing.mapper.WheelMapper;
import com.autohome.autoracing.pojo.Wheel;
import com.autohome.autoracing.service.WheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WheelServiceImpl extends BaseServiceImpl<Wheel> implements WheelService {
    @Autowired
    public WheelServiceImpl(WheelMapper bodyworkMapper) {
        super(bodyworkMapper);
    }
}