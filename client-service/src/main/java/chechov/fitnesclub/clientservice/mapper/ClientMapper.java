package chechov.fitnesclub.clientservice.mapper;

import chechov.fitnesclub.clientservice.dto.ClientDto;
import chechov.fitnesclub.clientservice.entity.Client;
import chechov.fitnesclub.clientservice.entity.ClientBuy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    @Mapping(target = "clientBuys", source = "clientBuyIds", qualifiedByName = "mapIdToClientBuys")
    Client toEntity(ClientDto dto);

    @Mapping(target = "clientBuyIds", source = "clientBuys", qualifiedByName = "mapClientBuysToIds")
    ClientDto toDto(Client entity);

    @Named("mapIdToClientBuys")
    default List<ClientBuy> mapIdToClientBuys(List<UUID> clientBuyIds) {
        return clientBuyIds.stream()
                .map((uuid) -> ClientBuy.builder()
                        .id(uuid)
                        .build())
                .toList();
    }

    @Named("mapClientBuysToIds")
    default List<UUID> mapClientBuysToIds(List<ClientBuy> clientBuys) {
        return clientBuys.stream()
                .map(ClientBuy::getId)
                .toList();
    }
}
