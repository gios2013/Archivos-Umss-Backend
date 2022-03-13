package org.umss.aub.service.tramites.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.tramites.Solicitud;
import org.umss.aub.dto.tramites.SolicitudDTO;
import org.umss.aub.repository.tramites.SolicitudRepository;
import org.umss.aub.service.tramites.SolicitudService;
import org.umss.aub.service.tramites.mapper.SolicitudMapper;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SolicitudServiceImpl implements SolicitudService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SolicitudServiceImpl.class);

    @Autowired
    private SolicitudRepository solicitudRepository;

    public List<SolicitudDTO> list() {
        List<Solicitud> solicitudes = solicitudRepository.findAll();
        List<SolicitudDTO> solicitudDTOS = new ArrayList<>();
        for (Solicitud solicitude : solicitudes) {
            SolicitudDTO solicitudDTO = SolicitudMapper.INSTANCE.solicitudToSolicitudDTO(solicitude);
            solicitudDTOS.add(solicitudDTO);
        }
        return solicitudDTOS;
    }

    @Override
    public SolicitudDTO create(SolicitudDTO solicitudDTO) {
        Solicitud solicitud = SolicitudMapper.INSTANCE.solicitudDTOToSolicitud(solicitudDTO);
        solicitud = this.solicitudRepository.save(solicitud);

        return SolicitudMapper.INSTANCE.solicitudToSolicitudDTO(solicitud);
    }

    @Override
    public SolicitudDTO get(Long id) {
        try {
            Solicitud solicitud = this.solicitudRepository.getById(id);
            return SolicitudMapper.INSTANCE.solicitudToSolicitudDTO(solicitud);
        } catch (EntityNotFoundException e) {
            LOGGER.info("Solicitud {} not found in database", id);
            throw new EntityNotFoundException(String.format("Solicitud %s not found.", id));
        }
    }
}
