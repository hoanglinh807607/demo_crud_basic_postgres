package com.postgresql.connect_postgresql.service;

import com.postgresql.connect_postgresql.dto.AccountDto;

import java.util.List;

public interface IAccountService<T> extends GenericeService<T> {
    List<AccountDto> findAll(Integer limit);
}
