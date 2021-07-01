package com.postgresql.connect_postgresql.repositories;

import com.postgresql.connect_postgresql.entities.AccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface AccountRepos extends PagingAndSortingRepository<AccountEntity, Long> {

    AccountEntity findByUsername(String username);

    @Query("Select a from AccountEntity a")
    List<AccountEntity> findAll(Pageable pageable);

}
