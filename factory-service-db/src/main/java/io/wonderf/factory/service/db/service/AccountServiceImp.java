package io.wonderf.factory.service.db.service;

import io.wonderf.factory.service.db.entity.Account;
import io.wonderf.factory.service.db.model.AccountDto;
import io.wonderf.factory.service.db.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

    AccountRepository accountRepository;

    @Override
    public Account create(AccountDto accountDto) {
        Account newAccount = new Account(accountDto.getId(),
                accountDto.getUsername(), accountDto.getPass(), accountDto.getSetting());
        log.debug("Received a request to create an account: {}", newAccount.getId());
        return accountRepository.save(newAccount);
    }

    @Override
    public Account update(AccountDto accountDto) {
        Account oldAccount = findById(accountDto.getId());
        if (accountDto.getPass() != null && accountDto.getPass().isEmpty()
                && !accountDto.getPass().equals(oldAccount.getPass())) {
            oldAccount.setPass(accountDto.getPass());
        }
        if (accountDto.getUsername() != null && accountDto.getUsername().isEmpty()
                && !accountDto.getUsername().equals(oldAccount.getUsername())) {
            oldAccount.setUsername(accountDto.getUsername());
        }
        if (accountDto.getSetting() != null && !accountDto.getSetting().equals(oldAccount.getSetting())) {
            oldAccount.setSetting(accountDto.getSetting());
        }
        log.debug("Account update request received - account: {}", oldAccount.getId());
        return accountRepository.save(oldAccount);
    }

    @Override
    public List<Account> findAll() {
        log.debug("Received a request to list all accounts");
        return new ArrayList<>(accountRepository.findAll());
    }

    @Override
    public Account findById(Integer id) {
        log.debug("A request was received to search for an account by ID {}", id);
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID " + id + " не найден"));
    }

    @Override
    public void delete(AccountDto accountDto) {
        Account account = findById(accountDto.getId());
        log.debug("Account deletion request received - account: {}", account.getId());
        accountRepository.delete(account);
    }
}
