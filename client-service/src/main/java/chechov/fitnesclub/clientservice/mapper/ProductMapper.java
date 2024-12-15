package chechov.fitnesclub.clientservice.mapper;

import chechov.fitnesclub.clientservice.dto.ProductDto;
import chechov.fitnesclub.clientservice.entity.ClientBuy;
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

    @Mapping(target = "clientBuysIds", source = "clientBuys", qualifiedByName = "mapClientBuysToIds")
    ProductDto toDto(Product entity);

@Named("mapClientBuysToIds")
    default List<UUID> mapClientBuysToIds(List<ClientBuy> clientBuys) {
        return clientBuys.stream()
//                .map(new Function<ClientBuy, UUID>() {
//                    @Override
//                    public UUID apply(ClientBuy clientBuy) {
//                        return clientBuy.getId();
//                    }
//                })
//                .toList();
                .map(ClientBuy::getId).toList();
    }
}
