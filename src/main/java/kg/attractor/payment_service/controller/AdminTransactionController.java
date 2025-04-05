package kg.attractor.payment_service.controller;

import kg.attractor.payment_service.dto.TransactionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/transactions")
public class AdminTransactionController {

    @GetMapping
    public List<TransactionDto> getAllTransactions() {
        // TODO: вернуть все транзакции
        return List.of();
    }

    @GetMapping("/approval")
    public List<TransactionDto> getTransactionsForApproval() {
        // TODO: вернуть транзакции, ожидающие одобрения
        return List.of();
    }

    @PostMapping("/approval")
    public String approveTransaction(@RequestParam Long transactionId) {
        // TODO: одобрить транзакцию
        return "Transaction approved";
    }

    @PostMapping("/rollback")
    public String rollbackTransaction(@RequestParam Long transactionId) {
        // TODO: откат транзакции
        return "Transaction rolled back";
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        // TODO: удалить запись из журнала после отката
        return "Transaction deleted";
    }
}