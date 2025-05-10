package chechov.fitnesclub.clientservice.mapper;

import chechov.fitnesclub.clientservice.dto.ProductDto;
import chechov.fitnesclub.clientservice.entity.Order;
import chechov.fitnesclub.clientservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product toEntity(ProductDto dto);

    @Mapping(target = "orderIds", source = "orders", qualifiedByName = "mapOrdersToIds")
    ProductDto toDto(Product entity);

    @Named("mapOrdersToIds")
    default List<UUID> mapOrdersToIds(List<Order> orders) {
        return orders.stream().map(Order::getId).toList();
    }
}
