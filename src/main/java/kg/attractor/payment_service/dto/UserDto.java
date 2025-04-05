package kg.attractor.payment_service.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "Телефон не должен быть пустым")
    @Pattern(regexp = "996\\d{9}", message = "Номер должен быть в формате 996XXXXXXXXX")
    private String phoneNumber;

    @NotBlank(message = "Имя не должно быть пустым")
    private String username;

    @NotBlank(message = "Пароль не должен быть пустым")
    private String password;
}
