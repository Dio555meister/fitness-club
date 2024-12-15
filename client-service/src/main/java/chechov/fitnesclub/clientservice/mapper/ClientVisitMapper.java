package chechov.fitnesclub.clientservice.mapper;

import chechov.fitnesclub.clientservice.dto.ClientVisitDto;
import chechov.fitnesclub.clientservice.entity.ClientVisit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientVisitMapper {

    ClientVisit toEntity(ClientVisitDto dto);

    ClientVisitDto toDto(ClientVisit entity);
}
