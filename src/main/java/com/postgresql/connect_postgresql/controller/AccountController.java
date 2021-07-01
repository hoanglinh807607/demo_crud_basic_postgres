package com.postgresql.connect_postgresql.controller;

import com.postgresql.connect_postgresql.dto.AccountDto;
import com.postgresql.connect_postgresql.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> create(@RequestBody @Valid AccountDto account) {
        return ResponseEntity.ok(accountService.createOrUpdate(account));
    }

    @PutMapping("/account")
    public ResponseEntity<?> update(@RequestBody @Valid AccountDto accountDto) {
        return ResponseEntity.ok(accountService.createOrUpdate(accountDto));
    }

    @DeleteMapping("/account")
    public ResponseEntity<?> delete(@RequestBody AccountDto accountDto) {
        Boolean success = accountService.delete(accountDto.getIds());
        String result = "Fail delete";
        if (success) result = "Success delete";
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // Nếu validate fail thì trả về 400
    @ResponseBody
    public String handleBindException(BindException e) {
        // Trả về message của lỗi đầu tiên
        String errorMessage = "Request không hợp lệ";
        if (e.getBindingResult().hasErrors())
            errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return errorMessage;
    }


}
