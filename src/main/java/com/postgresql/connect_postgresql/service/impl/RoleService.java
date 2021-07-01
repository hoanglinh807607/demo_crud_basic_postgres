package com.postgresql.connect_postgresql.service.impl;

import com.postgresql.connect_postgresql.dto.RoleDto;
import com.postgresql.connect_postgresql.service.IRoleService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleService implements IRoleService<RoleDto> {
    @Override
    public RoleDto findOne(Long id) {
        return null;
    }

    @Override
    public List<RoleDto> findAll() {
        return null;
    }

    @Override
    public List<RoleDto> findAll(Integer limit) {
        return null;
    }

    @Override
    public RoleDto createOrUpdate(RoleDto dto) {
        return null;
    }

    @Override
    public Boolean delete(Long[] id) {
        return null;
    }
}
