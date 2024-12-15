package chechov.fitnesclub.clientservice.mapper;

import chechov.fitnesclub.clientservice.dto.ClientBuyDto;
import chechov.fitnesclub.clientservice.entity.ClientBuy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientBuyMapper {

    ClientBuy toEntity(ClientBuyDto dto);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "productId", source = "product.id")
    ClientBuyDto toDto(ClientBuy entity);
}
