package com.autohome.autoracing.service.impl;


import com.autohome.autoracing.mapper.ShaftMapper;
import com.autohome.autoracing.pojo.Shaft;
import com.autohome.autoracing.service.ShaftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShaftServiceImpl extends BaseServiceImpl<Shaft> implements ShaftService {
    @Autowired
    public ShaftServiceImpl(ShaftMapper shaftMapper) {
        super(shaftMapper);
    }
}