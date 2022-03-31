package org.umss.aub.service.tramites.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.umss.aub.domain.tramites.Solicitud;
import org.umss.aub.dto.tramites.SolicitudDTO;

@Mapper(componentModel = "spring")
public interface SolicitudMapper {
    SolicitudMapper INSTANCE = Mappers.getMapper(SolicitudMapper.class);

    Solicitud solicitudDTOToSolicitud(SolicitudDTO solicitudDTO);

    SolicitudDTO solicitudToSolicitudDTO(Solicitud solicitud);
}
