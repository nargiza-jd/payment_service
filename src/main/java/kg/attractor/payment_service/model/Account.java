package kg.attractor.payment_service.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String currency;
    private Double balance;
    private Long userId;
}