package chechov.fitnesclub.clientservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class OrderDto {

    @EqualsAndHashCode.Include
    private UUID id;
    private UUID clientId;
    private UUID productId;
    private UUID paymentId;
    private BigDecimal amount;
    private LocalDateTime date;
}
