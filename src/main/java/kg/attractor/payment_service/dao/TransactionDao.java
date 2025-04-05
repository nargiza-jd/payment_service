package kg.attractor.payment_service.dao;

import kg.attractor.payment_service.dao.mapper.TransactionMapper;
import kg.attractor.payment_service.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionDao {

    private final JdbcTemplate jdbcTemplate;
    private final TransactionMapper transactionMapper;

    public List<Transaction> findAll() {
        String sql = "SELECT * FROM transactions";
        return jdbcTemplate.query(sql, transactionMapper);
    }

    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions (sender_account_id, receiver_account_id, amount, currency, status, timestamp) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                transaction.getSenderAccountId(),
                transaction.getReceiverAccountId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getStatus(),
                transaction.getTimestamp());
    }
}