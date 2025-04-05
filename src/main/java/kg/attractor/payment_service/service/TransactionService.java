package kg.attractor.payment_service.service;

import kg.attractor.payment_service.model.Transaction;

import java.util.List;

public interface TransactionService {
    void transfer(Long senderAccountId, Long receiverAccountId, double amount);
    List<Transaction> getTransactionsByAccount(Long accountId);
    List<Transaction> getAllTransactions();
    List<Transaction> getPendingTransactions();
    void approveTransaction(Long transactionId);
    void rollbackTransaction(Long transactionId);
}
