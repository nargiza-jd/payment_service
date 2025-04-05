package kg.attractor.payment_service.dao;

import kg.attractor.payment_service.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountDao {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Account> rowMapper = (rs, rowNum) -> Account.builder()
            .id(rs.getLong("id"))
            .currency(rs.getString("currency"))
            .balance(rs.getDouble("balance"))
            .userId(rs.getLong("user_id"))
            .build();

    public void save(Account account) {
        String sql = "INSERT INTO accounts (currency, balance, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, account.getCurrency(), account.getBalance(), account.getUserId());
    }

    public Optional<Account> findById(Long id) {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        List<Account> accounts = jdbcTemplate.query(sql, rowMapper, id);
        return accounts.stream().findFirst();
    }

    public List<Account> findAllByUserId(Long userId) {
        String sql = "SELECT * FROM accounts WHERE user_id = ?";
        return jdbcTemplate.query(sql, rowMapper, userId);
    }

    public void updateBalance(Long accountId, Double newBalance) {
        String sql = "UPDATE accounts SET balance = ? WHERE id = ?";
        jdbcTemplate.update(sql, newBalance, accountId);
    }
}