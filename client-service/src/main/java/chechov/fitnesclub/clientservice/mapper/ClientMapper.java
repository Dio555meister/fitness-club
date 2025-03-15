package chechov.fitnesclub.clientservice.mapper;

import chechov.fitnesclub.clientservice.dto.ClientDto;
import chechov.fitnesclub.clientservice.entity.Client;
import chechov.fitnesclub.clientservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    @Mapping(target = "orders", source = "clientBuyIds", qualifiedByName = "mapIdToClientBuys")
    Client toEntity(ClientDto dto);

    @Mapping(target = "clientBuyIds", source = "orders", qualifiedByName = "mapClientBuysToIds")
    ClientDto toDto(Client entity);

    @Named("mapIdToClientBuys")
    default List<Order> mapIdToClientBuys(List<UUID> clientBuyIds) {
        return clientBuyIds.stream()
                .map((uuid) -> Order.builder()
                        .id(uuid)
                        .build())
                .toList();
    }

    @Named("mapClientBuysToIds")
    default List<UUID> mapClientBuysToIds(List<Order> orders) {
        return orders.stream()
                .map(Order::getId)
                .toList();
    }
}
