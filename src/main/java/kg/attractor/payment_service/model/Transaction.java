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
    private Long senderAccountId;
    private Long receiverAccountId;
    private Double amount;
    private String currency;
    private String status;
    private LocalDateTime timestamp;
}