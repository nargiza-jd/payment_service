package kg.attractor.payment_service.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RollbackLog {
    private Long id;
    private Long transactionId;
    private LocalDateTime rollbackTime;
    private String reason;
}