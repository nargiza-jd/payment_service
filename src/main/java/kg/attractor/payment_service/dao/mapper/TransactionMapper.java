package kg.attractor.payment_service.dao.mapper;

import kg.attractor.payment_service.model.Transaction;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TransactionMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Transaction.builder()
                .id(rs.getLong("id"))
                .senderAccountId(rs.getLong("sender_account_id"))
                .receiverAccountId(rs.getLong("receiver_account_id"))
                .amount(rs.getDouble("amount"))
                .currency(rs.getString("currency"))
                .status(rs.getString("status"))
                .timestamp(rs.getTimestamp("timestamp").toLocalDateTime())
                .build();
    }
}