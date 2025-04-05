package kg.attractor.payment_service.dao.mapper;

import kg.attractor.payment_service.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Account.builder()
                .id(rs.getLong("id"))
                .currency(rs.getString("currency"))
                .balance(rs.getDouble("balance"))
                .userId(rs.getLong("user_id"))
                .build();
    }
}
