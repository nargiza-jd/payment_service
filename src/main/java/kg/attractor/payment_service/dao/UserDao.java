package kg.attractor.payment_service.dao;

import kg.attractor.payment_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> User.builder()
            .id(rs.getLong("id"))
            .phoneNumber(rs.getString("phone_number"))
            .username(rs.getString("username"))
            .password(rs.getString("password"))
            .role(rs.getString("role"))
            .build();

    public void save(User user) {
        String sql = "INSERT INTO users (phone_number, username, password, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getPhoneNumber(), user.getUsername(), user.getPassword(), user.getRole());
    }

    public boolean existsByPhoneNumber(String phoneNumber) {
        String sql = "SELECT COUNT(*) FROM users WHERE phone_number = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, phoneNumber);
        return count != null && count > 0;
    }

    public User findByPhoneNumber(String phoneNumber) {
        String sql = "SELECT * FROM users WHERE phone_number = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, phoneNumber);
    }
}