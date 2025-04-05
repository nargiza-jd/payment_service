package kg.attractor.payment_service.dao;

import kg.attractor.payment_service.model.RollbackLog;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RollbackLogDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(RollbackLog log) {
        String sql = "INSERT INTO rollback_logs (transaction_id, rollback_date, reason) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                log.getTransactionId(),
                log.getRollbackDate(),
                log.getReason());
    }

    public List<RollbackLog> findAll() {
        String sql = "SELECT * FROM rollback_logs";
        return jdbcTemplate.query(sql, rollbackLogRowMapper);
    }

    private final RowMapper<RollbackLog> rollbackLogRowMapper = (rs, rowNum) -> RollbackLog.builder()
            .id(rs.getLong("id"))
            .transactionId(rs.getLong("transaction_id"))
            .rollbackDate(rs.getTimestamp("rollback_date").toLocalDateTime())
            .reason(rs.getString("reason"))
            .build();
}
