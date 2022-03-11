package org.umss.aub.service.tramites.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.tramites.Tramites;
import org.umss.aub.dto.tramites.TramitesDTO;
import org.umss.aub.repository.tramites.TramiteRepository;
import org.umss.aub.service.tramites.TramiteService;
import org.umss.aub.service.tramites.mapper.TramiteMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TramiteServiceImpl implements TramiteService {


    private final TramiteRepository tramiteRepository;

    private final TramiteMapper tramiteMapper;

    public TramiteServiceImpl(TramiteRepository tramiteRepository, TramiteMapper tramiteMapper) {
        this.tramiteRepository = tramiteRepository;
        this.tramiteMapper = tramiteMapper;
    }


    @Override
    public TramitesDTO save(TramitesDTO tramitesDTO) {
        Tramites tramites = tramiteMapper.toEntity(tramitesDTO);
        return tramiteMapper.toDto(tramiteRepository.save(tramites));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TramitesDTO> findById(Integer id) {
        return tramiteRepository.findById(id).map(tramiteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public TramitesDTO findByUuid(String Uuid) {
        return tramiteMapper.toDto(tramiteRepository.findOneByUuid(Uuid));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TramitesDTO> findAll() {
        return tramiteRepository.findAll()
                .stream()
                .map(tramiteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TramitesDTO> findAllActive() {
        return null;
    }

    @Override
    public void logicalDelete(Integer id) {
    }


}
