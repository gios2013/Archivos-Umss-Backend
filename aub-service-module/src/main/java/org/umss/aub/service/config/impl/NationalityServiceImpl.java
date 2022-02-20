package org.umss.aub.service.config.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.Nationality;
import org.umss.aub.dto.config.NationalityDTO;
import org.umss.aub.repository.config.NationalityRepository;
import org.umss.aub.service.config.NationalityService;
import org.umss.aub.service.config.mapper.NationalityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class NationalityServiceImpl implements NationalityService {

    private final NationalityRepository nationalityRepository;

    private final NationalityMapper nationalityMapper;

    public NationalityServiceImpl(NationalityRepository nationalityRepository, NationalityMapper nationalityMapper) {
        this.nationalityRepository = nationalityRepository;
        this.nationalityMapper = nationalityMapper;
    }

    @Override
    public NationalityDTO save(NationalityDTO nationalityDTO) {
        Nationality nationality = nationalityMapper.toEntity(nationalityDTO);
        return nationalityMapper.toDto(nationalityRepository.save(nationality));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NationalityDTO> findById(Integer id) {
        return nationalityRepository.findById(id).map(nationalityMapper::toDto);
    }

    @Override
    public NationalityDTO findByUuid(String Uuid) {
        return null;
    }

    @Override
    public Page<NationalityDTO> findAll(Pageable pageable) {
        List<NationalityDTO> nationalities = nationalityRepository.findAll(pageable)
                .stream().map(nationalityMapper::toDto)
                .collect(Collectors.toList());

        return new PageImpl<>(nationalities);
    }

    @Override
    public List<NationalityDTO> findAllActive() {
        return null;
    }

    @Override
    public void logicalDelete(Integer id) {
        nationalityRepository.deleteById(id);
    }
}
