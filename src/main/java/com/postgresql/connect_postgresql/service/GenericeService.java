package com.postgresql.connect_postgresql.service;

import java.util.List;

public interface GenericeService<T> {
    T findOne(Long id);

    List<T> findAll();

    T createOrUpdate(T dto);

    Boolean delete(Long[] id);
}
