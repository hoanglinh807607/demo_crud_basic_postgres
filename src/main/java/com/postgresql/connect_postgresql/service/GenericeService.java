package com.postgresql.connect_postgresql.service;

import java.util.List;

public interface GenericeService<T> {
    T findOne(Long id);

    List<T> findAll();

    List<T> findAll(Integer limit);

    T createOrUpdate(T dto);

    Boolean delete(Long[] id);
}
