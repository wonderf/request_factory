package io.wonderf.factory.service.api.controller;

import io.wonderf.factory.service.api.model.response.AccountResponse;
import io.wonderf.factory.service.db.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping
    public List<AccountResponse> accounts(){
        return accountService.findAll().stream().map(dto->new AccountResponse()).collect(Collectors.toList());
    }
}
