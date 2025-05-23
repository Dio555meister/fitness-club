package chechov.fitnesclub.clientservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class ProductDto {
    @EqualsAndHashCode.Exclude
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<UUID> orderIds;
}
