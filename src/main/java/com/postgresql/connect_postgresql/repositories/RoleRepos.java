package com.postgresql.connect_postgresql.repositories;

import com.postgresql.connect_postgresql.entities.RoleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepos extends PagingAndSortingRepository<RoleEntity, Long> {

    RoleEntity findByCode(String code);

}
