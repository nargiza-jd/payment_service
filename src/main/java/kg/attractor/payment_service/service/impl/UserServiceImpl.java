package kg.attractor.payment_service.service.impl;

import jakarta.annotation.PostConstruct;
import kg.attractor.payment_service.dao.UserDao;
import kg.attractor.payment_service.dto.UserDto;
import kg.attractor.payment_service.model.User;
import kg.attractor.payment_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserDto userDto) {
        if (userDao.existsByPhoneNumber(userDto.getPhoneNumber())) {
            throw new IllegalArgumentException("Пользователь с таким номером уже существует");
        }

        User user = User.builder()
                .phoneNumber(userDto.getPhoneNumber())
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role("ROLE_USER")
                .build();

        userDao.save(user);
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return userDao.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return userDao.findByPhoneNumber(phoneNumber);
    }

    @PostConstruct
    public void createTestUser() {
        if (!userDao.existsByPhoneNumber("00000")) {
            User testUser = User.builder()
                    .phoneNumber("00000")
                    .username("test")
                    .password(passwordEncoder.encode("1234"))
                    .role("ROLE_ADMIN")
                    .build();
            userDao.save(testUser);
        }
    }
}