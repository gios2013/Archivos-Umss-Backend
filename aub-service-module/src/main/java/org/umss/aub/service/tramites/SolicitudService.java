package org.umss.aub.service.tramites;

import org.umss.aub.dto.tramites.SolicitudDTO;

import java.util.List;

public interface SolicitudService {

    List<SolicitudDTO> list();

    SolicitudDTO create(SolicitudDTO solicitudDTO);

    SolicitudDTO get(Long id);
}
