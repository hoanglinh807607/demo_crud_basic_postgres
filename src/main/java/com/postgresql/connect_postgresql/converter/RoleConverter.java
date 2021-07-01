package com.postgresql.connect_postgresql.converter;

import com.postgresql.connect_postgresql.dto.RoleDto;
import com.postgresql.connect_postgresql.entities.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements AbtractConverter<RoleDto, RoleEntity> {

    @Override
    public RoleDto toDto(RoleEntity entity) {
        RoleDto role = RoleDto.builder().code(entity.getCode())
                .name(entity.getName()).build();
        role.setId(entity.getId());
        return role;
    }

    @Override
    public RoleEntity toEntity(RoleDto dto) {
        return null;
    }

    @Override
    public RoleEntity toEntity(RoleEntity entity, RoleDto dto) {
        return null;
    }
}
