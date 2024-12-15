package chechov.fitnesclub.clientservice.dto;

import chechov.fitnesclub.clientservice.entity.enums.Gender;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class ClientDto {

    @EqualsAndHashCode.Include
    private UUID id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String address;
    private Gender gender;
    private UUID membershipId;
    @ToString.Exclude
    private List<UUID> clientBuyIds;
}
