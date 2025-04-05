package kg.attractor.payment_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Long id;
    private Long senderAccountId;
    private Long receiverAccountId;
    private Double amount;
    private String currency;
    private String status;
}