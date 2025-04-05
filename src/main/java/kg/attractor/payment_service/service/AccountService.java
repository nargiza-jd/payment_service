package kg.attractor.payment_service.service;

import kg.attractor.payment_service.model.Account;

import java.util.List;

public interface AccountService {
    void createAccount(Long userId, String currency);
    List<Account> getAccountsByUserId(Long userId);
    Account getAccountById(Long accountId);
    void topUpBalance(Long accountId, double amount);
}