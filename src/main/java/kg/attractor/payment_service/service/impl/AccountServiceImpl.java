package kg.attractor.payment_service.service.impl;

import kg.attractor.payment_service.dao.AccountDao;
import kg.attractor.payment_service.model.Account;
import kg.attractor.payment_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Override
    public void createAccount(Long userId, String currency) {
        Account account = Account.builder()
                .userId(userId)
                .currency(currency)
                .balance(0.0)
                .build();
        accountDao.save(account);
    }

    @Override
    public List<Account> getAccountsByUserId(Long userId) {
        return accountDao.findAllByUserId(userId);
    }

    @Override
    public Account getAccountById(Long accountId) {
        return accountDao.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + accountId));
    }

    @Override
    public void topUpBalance(Long accountId, double amount) {
        Account account = getAccountById(accountId);
        double newBalance = account.getBalance() + amount;
        accountDao.updateBalance(accountId, newBalance);
    }
}