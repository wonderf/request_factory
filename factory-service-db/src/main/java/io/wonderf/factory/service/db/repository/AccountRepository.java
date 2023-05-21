package io.wonderf.factory.service.db.repository;

import io.wonderf.factory.service.db.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
