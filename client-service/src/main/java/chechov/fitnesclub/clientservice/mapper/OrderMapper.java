package chechov.fitnesclub.clientservice.mapper;

import chechov.fitnesclub.clientservice.dto.OrderDto;
import chechov.fitnesclub.clientservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    Order toEntity(OrderDto dto);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "productId", source = "product.id")
    OrderDto toDto(Order entity);
}
