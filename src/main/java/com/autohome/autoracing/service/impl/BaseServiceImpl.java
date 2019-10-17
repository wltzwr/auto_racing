package com.autohome.autoracing.service.impl;

import com.autohome.autoracing.service.BaseService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public  class BaseServiceImpl<T> implements BaseService<T> {
    private final BaseMapper<T> baseMapper;

    protected BaseMapper<T> getBaseMapper(){return baseMapper;}

    BaseServiceImpl(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }


    @Override
    public Integer delete(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Integer insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public T select(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer update(T record) {
        return baseMapper.updateById(record);
    }

    @Override
    public List<T> selectList() {
        return baseMapper.selectList(null);
    }
}
