package chechov.fitnesclub.clientservice.dto;

import chechov.fitnesclub.clientservice.entity.Client;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class ClientBuyDto {

    @EqualsAndHashCode.Include
    private UUID id;
    private UUID clientId;
    private UUID productId;
    private UUID paymentId;
    private BigDecimal amount;
    private LocalDateTime buyDate;
}
