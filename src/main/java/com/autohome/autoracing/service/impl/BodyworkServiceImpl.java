package com.autohome.autoracing.service.impl;


import com.autohome.autoracing.mapper.BodyworkMapper;
import com.autohome.autoracing.pojo.Bodywork;
import com.autohome.autoracing.service.BodyworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyworkServiceImpl extends BaseServiceImpl<Bodywork> implements BodyworkService {
    @Autowired
    public BodyworkServiceImpl(BodyworkMapper bodyworkMapper) {
        super(bodyworkMapper);
    }
}