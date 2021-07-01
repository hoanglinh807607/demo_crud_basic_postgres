package com.postgresql.connect_postgresql.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Data
@Table(name = "role")
public class RoleEntity extends BaseEntity {

    @ManyToMany(mappedBy = "roleList", fetch = FetchType.LAZY)
    Collection<AccountEntity> accountList;
    private String code;
    private String name;
}
