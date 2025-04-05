package kg.attractor.payment_service.dao;

import kg.attractor.payment_service.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    void save(Account account);
    Optional<Account> findById(Long id);
    List<Account> findAllByUserId(Long userId);
}