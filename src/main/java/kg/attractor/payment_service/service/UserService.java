package kg.attractor.payment_service.service;
import kg.attractor.payment_service.dto.UserDto;

public interface UserService {
    void register(UserDto userDto);
}