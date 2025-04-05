package kg.attractor.payment_service.dao.mapper;

import kg.attractor.payment_service.model.RollbackLog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RollbackLogMapper implements RowMapper<RollbackLog> {
    @Override
    public RollbackLog mapRow(ResultSet rs, int rowNum) throws SQLException {
        return RollbackLog.builder()
                .id(rs.getLong("id"))
                .transactionId(rs.getLong("transaction_id"))
                .rollbackDate(rs.getTimestamp("rollback_date").toLocalDateTime())
                .reason(rs.getString("reason"))
                .build();
    }
}
