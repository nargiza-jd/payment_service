package kg.attractor.payment_service.config;

import kg.attractor.payment_service.dao.UserDao;
import kg.attractor.payment_service.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDao userDao;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(userDao);
    }
}