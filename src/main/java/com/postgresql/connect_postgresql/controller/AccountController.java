package com.postgresql.connect_postgresql.controller;

import com.postgresql.connect_postgresql.dto.AccountDto;
import com.postgresql.connect_postgresql.exception.ErrorRespone;
import com.postgresql.connect_postgresql.exception.NotFoundException;
import com.postgresql.connect_postgresql.service.impl.AccountService;
import com.sun.jdi.request.InvalidRequestStateException;
import javassist.tools.web.BadHttpRequest;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    public ResponseEntity<?> getAll(@RequestParam(name = "limit", required = false) Integer limit) {
        if (limit != null) {
            return ResponseEntity.ok(accountService.findAll(limit));
        } else {
            return ResponseEntity.ok(accountService.findAll());
        }
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        AccountDto accountDto = accountService.findOne(id);
        return accountDto != null ? ResponseEntity.ok(accountDto) : ResponseEntity.ok("Id not found");
    }

    @PostMapping("/account")
    public ResponseEntity<?> create(@RequestBody @Valid AccountDto account) throws BindException {
        return ResponseEntity.ok(accountService.createOrUpdate(account));
    }

    @PutMapping("/account")
    public ResponseEntity<?> update(@RequestBody @Valid AccountDto accountDto) throws BindException  {
        return ResponseEntity.ok(accountService.createOrUpdate(accountDto));
    }

    @DeleteMapping("/account")
    public ResponseEntity<?> delete(@RequestBody AccountDto accountDto) {
        Boolean success = accountService.delete(accountDto.getIds());
        return ResponseEntity.ok("Success delete");
    }

}
