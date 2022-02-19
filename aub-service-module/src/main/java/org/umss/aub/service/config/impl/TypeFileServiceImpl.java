package org.umss.aub.service.config.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.TypeFileDTO;
import org.umss.aub.repository.config.TypeFileRepository;
import org.umss.aub.service.config.TypeFileService;
import org.umss.aub.service.config.mapper.TypeFileMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TypeFileServiceImpl implements TypeFileService {

    private final TypeFileRepository typeFileRepository;

    private final TypeFileMapper typeFileMapper;

    public TypeFileServiceImpl(TypeFileRepository typeFileRepository, TypeFileMapper typeFileMapper) {
        this.typeFileRepository = typeFileRepository;
        this.typeFileMapper = typeFileMapper;
    }


    @Override
    public TypeFileDTO save(TypeFileDTO typeFileDTO) {
        TypeFile typeFile = typeFileMapper.toEntity(typeFileDTO);
        return typeFileMapper.toDto(typeFileRepository.save(typeFile));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TypeFileDTO> findById(Integer id) {
        return typeFileRepository.findById(id).map(typeFileMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public TypeFileDTO findByUuid(String Uuid) {
        TypeFile typeFile = typeFileRepository.findOneByUuid(Uuid);
        return typeFileMapper.toDto(typeFile);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeFileDTO> findAll() {
        return typeFileRepository.findAll().
                stream().map(typeFileMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeFileDTO> findAllActive() {
        return null;
    }

    @Override
    public void logicalDelete(Integer id) {

    }
}
