package io.wonderf.factory.service.db.service;

import io.wonderf.factory.service.db.entity.Account;
import io.wonderf.factory.service.db.model.AccountDto;

import java.util.List;

public interface AccountService {
    Account create(AccountDto accountDto);

    Account update(AccountDto accountDto);

    List<Account> findAll();

    Account findById(Integer id);

    void delete(AccountDto accountDto);
}
