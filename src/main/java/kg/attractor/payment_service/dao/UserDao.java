package kg.attractor.payment_service.dao;

import kg.attractor.payment_service.dao.mapper.UserMapper;
import kg.attractor.payment_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper = new UserMapper();

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
        return jdbcTemplate.queryForObject(sql, userMapper, phoneNumber);
    }

    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.query(sql, userMapper, username).stream().findFirst();
    }
}