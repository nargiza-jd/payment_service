package kg.attractor.payment_service.service;

import kg.attractor.payment_service.dto.UserDto;
import kg.attractor.payment_service.model.User;

public interface UserService {
    void register(UserDto userDto);
    boolean existsByPhoneNumber(String phoneNumber);
    User findByPhoneNumber(String phoneNumber);
}