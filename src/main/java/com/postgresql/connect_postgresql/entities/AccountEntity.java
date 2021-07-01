package com.postgresql.connect_postgresql.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "account")
public class AccountEntity extends BaseEntity {

    private String username;
    private String password;

    @Column(name = "fullname")
    private String fullName;

    private String phone;
    private String address;

    @ManyToMany
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<RoleEntity> roleList;

}
