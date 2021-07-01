package com.postgresql.connect_postgresql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto extends AbtractDto {
    @NotNull(message = "Username must not null")
    @Size(min = 6, max = 20, message = "Min size is 2 and max size is 50")
    private String username;

    @NotNull(message = "Password must not null")
    @Size(min = 6, max = 30, message = "Min size is 2 and max size is 30")
    private String password;

    @NotNull(message = "Full name must not null")
    private String fullName;

    @NotNull(message = "Number phone must not null")
    @Size(min = 10, max = 10, message = "invalid phone number")
    private String phone;

    @NotNull(message = "Address must not null")
    @Size(min = 1, max = 100, message = "Min size is 1 and max size is 50")
    private String address;

    private List<RoleDto> roleList;

}
