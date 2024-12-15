package chechov.fitnesclub.clientservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class ClientVisitDto {

    @EqualsAndHashCode.Include
    private UUID id;
    private UUID clientId;
    private LocalDateTime visitDate;
}
