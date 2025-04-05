package kg.attractor.payment_service.controller;

import kg.attractor.payment_service.dto.AccountDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @PostMapping
    public String createAccount(@RequestBody AccountDto accountDto) {
        // TODO: вызвать сервис создания счёта
        return "Account created";
    }

    @GetMapping
    public List<AccountDto> getAllAccounts() {
        // TODO: вернуть список всех счетов пользователя
        return List.of();
    }

    @GetMapping("/balance")
    public double getBalance(@RequestParam Long accountId) {
        // TODO: вернуть баланс по accountId
        return 0.0;
    }

    @PostMapping("/balance")
    public String topUpBalance(@RequestBody AccountDto accountDto) {
        // TODO: пополнить счёт текущего пользователя
        return "Balance updated";
    }
}
