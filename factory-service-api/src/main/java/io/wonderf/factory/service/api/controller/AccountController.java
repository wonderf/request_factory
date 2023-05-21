package io.wonderf.factory.service.api.controller;

import io.wonderf.factory.service.api.model.request.AccountCreateRequest;
import io.wonderf.factory.service.api.model.response.AccountResponse;
import io.wonderf.factory.service.db.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping
    public ResponseEntity<List<AccountResponse>> accounts(){
        return ResponseEntity.ok(accountService.findAll().stream().map(dto->new AccountResponse()).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> accountById(@PathVariable Integer id){
        return ResponseEntity.ok(AccountResponse.of(accountService.findById(id)));
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody AccountCreateRequest request){
        return ResponseEntity.created();
    }

    @PatchMapping
    public ResponseEntity<AccountResponse> updateAccount(@RequestBody AccountCreateRequest request){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Integer id){
        return null;
    }
}
