package com.postgresql.connect_postgresql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto extends AbtractDto {
    private String code;
    private String name;
    private List<AccountDto> accountDtoList;

}
