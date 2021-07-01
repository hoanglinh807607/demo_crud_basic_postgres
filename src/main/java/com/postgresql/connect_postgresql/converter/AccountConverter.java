package com.postgresql.connect_postgresql.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgresql.connect_postgresql.dto.AccountDto;
import com.postgresql.connect_postgresql.dto.RoleDto;
import com.postgresql.connect_postgresql.entities.AccountEntity;
import com.sun.istack.NotNull;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AccountConverter implements AbtractConverter<AccountDto, AccountEntity> {

    ObjectMapper objectMapper = new ObjectMapper();

    public AccountDto toDto(AccountEntity entity) {
//        AccountDto accountDto = null;
//        String objectEntity = null;
//        try {
//
//            objectEntity = objectMapper.writeValueAsString(entity);
//            accountDto = objectMapper.readValue(objectEntity, AccountDto.class);
//
//            AccountDto finalAccountDto = new AccountDto();
//            entity.getRoleList().forEach(roleEntity -> {
//                finalAccountDto.getRoleList().add(new RoleDto(roleEntity.getCode(), roleEntity.getName(), null));
//            });
//            accountDto.setRoleList(finalAccountDto.getRoleList());
//        }catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return accountDto;

        AccountDto accountDto = AccountDto.builder().username(entity.getUsername())
                .password(entity.getPassword())
                .fullName(entity.getFullName())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .roleList(new ArrayList<>())
                .build();
        accountDto.setId(entity.getId());
        entity.getRoleList().stream().forEach(roleEntity -> {
            accountDto.getRoleList().add(new RoleDto(roleEntity.getCode(), roleEntity.getName(), null));
        });
        return accountDto;
    }

    @Override
    public AccountEntity toEntity(AccountDto dto) {
        return getEntity(new AccountEntity(), dto);
    }

    @Override
    public AccountEntity toEntity(AccountEntity entity, AccountDto dto) {
        return getEntity(entity, dto);
    }

    @SneakyThrows
    @NotNull
    private AccountEntity getEntity(AccountEntity entity, AccountDto dto) {
        if (dto.getId() != null) entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFullName(dto.getFullName());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        return entity;
//        String objectDto = objectMapper.writeValueAsString(dto);
//        return objectMapper.readValue(objectDto, AccountEntity.class);
    }
}
