package com.autohome.autoracing.service;

import java.util.List;

public interface BaseService<T> {
    Integer delete(Integer id);

    Integer insert(T record);

    T select(Integer id);

    Integer update(T record);

    List<T> selectList();
}
