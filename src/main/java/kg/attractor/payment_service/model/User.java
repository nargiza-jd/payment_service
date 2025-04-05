package kg.attractor.payment_service.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String phoneNumber; // 996XXXXXXXXX
    private String username;
    private String password;
    private String role; // ROLE_USER, ROLE_ADMIN
}
