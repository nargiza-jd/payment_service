package kg.attractor.payment_service.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
    private String currency;
    private LocalDateTime timestamp;
    private String status;
}