package org.umss.aub.service.config.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.SectionFile;
import org.umss.aub.dto.config.SectionFileDTO;
import org.umss.aub.repository.config.SectionFileRepository;
import org.umss.aub.service.config.SectionFileService;
import org.umss.aub.service.config.mapper.SectionFileMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SectionFileServiceImpl implements SectionFileService {

    private final SectionFileRepository sectionFileRepository;
    private final SectionFileMapper sectionFileMapper;

    public SectionFileServiceImpl(SectionFileRepository sectionFileRepository, SectionFileMapper sectionFileMapper) {
        this.sectionFileRepository = sectionFileRepository;
        this.sectionFileMapper = sectionFileMapper;
    }

    @Override
    public SectionFileDTO save(SectionFileDTO sectionFileDTO) {
        var sectionFile = sectionFileMapper.toEntity(sectionFileDTO);
        return sectionFileMapper.toDto(sectionFileRepository.save(sectionFile));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SectionFileDTO> findById(Integer id) {
        return sectionFileRepository.findById(id).map(sectionFileMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SectionFileDTO> findAll() {
        return sectionFileRepository.findAll().stream().map(sectionFileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SectionFileDTO> findAllActive() {
        List<SectionFile> sectionActives = sectionFileRepository.findAll();
//                .stream()
//                .filter(SectionFile::getInitials_und)
//                .collect(Collectors.toList());
        return sectionActives.stream().map(sectionFileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void logicalDelete(Integer id) {
//        var sectionFile = sectionFileRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid Section Id " + id));
//
//        sectionFile.setActive(Boolean.FALSE);
//        sectionFileRepository.save(sectionFile);
    }

}
