package kg.attractor.payment_service.controller;

import kg.attractor.payment_service.dto.TransactionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @PostMapping
    public String createTransaction(@RequestBody TransactionDto dto) {
        // TODO: совершить транзакцию
        return "Transaction created";
    }

    @GetMapping("/{accountId}/history")
    public List<TransactionDto> getTransactionHistory(@PathVariable Long accountId) {
        // TODO: получить выписку по счёту
        return List.of();
    }
}
