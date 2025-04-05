package kg.attractor.payment_service.dao;

import kg.attractor.payment_service.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions (sender_account_id, receiver_account_id, amount, currency, status, timestamp) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                transaction.getSenderAccountId(),
                transaction.getReceiverAccountId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getStatus(),
                transaction.getTimestamp());
    }

    public List<Transaction> findAll() {
        String sql = "SELECT * FROM transactions";
        return jdbcTemplate.query(sql, transactionRowMapper);
    }

    private final RowMapper<Transaction> transactionRowMapper = (rs, rowNum) -> Transaction.builder()
            .id(rs.getLong("id"))
            .senderAccountId(rs.getLong("sender_account_id"))
            .receiverAccountId(rs.getLong("receiver_account_id"))
            .amount(rs.getDouble("amount"))
            .currency(rs.getString("currency"))
            .status(rs.getString("status"))
            .timestamp(rs.getTimestamp("timestamp").toLocalDateTime())
            .build();
}