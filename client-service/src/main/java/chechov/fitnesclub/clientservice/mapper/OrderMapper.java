package chechov.fitnesclub.clientservice.mapper;

import chechov.fitnesclub.clientservice.dto.OrderDto;
import chechov.fitnesclub.clientservice.entity.Order;
import chechov.fitnesclub.clientservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    Order toEntity(OrderDto dto);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "productIds", source = "products")
    OrderDto toDto(Order entity);

    default List<UUID> productsToIds(List<Product> products) {
        return products.stream().map(p -> p.getId()).toList();
    }
}
