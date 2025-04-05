package kg.attractor.payment_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RollbackLogDto {
    private Long id;
    private Long transactionId;
    private String rollbackDate;
    private String reason;
}