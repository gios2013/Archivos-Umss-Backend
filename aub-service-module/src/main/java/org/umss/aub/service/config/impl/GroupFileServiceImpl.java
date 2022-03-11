package org.umss.aub.service.config.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.GroupFile;
import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.repository.config.GroupFileRepository;
import org.umss.aub.service.config.GroupFileService;
import org.umss.aub.service.config.mapper.GroupFileMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupFileServiceImpl implements GroupFileService {

    private final GroupFileMapper groupFileMapper;

    private final GroupFileRepository groupFileRepository;

    public GroupFileServiceImpl(GroupFileMapper groupFileMapper, GroupFileRepository groupFileRepository) {
        this.groupFileMapper = groupFileMapper;
        this.groupFileRepository = groupFileRepository;
    }

    @Override
    public GroupFileDTO save(GroupFileDTO groupFileDTO) {
        GroupFile groupFile = groupFileMapper.toEntity(groupFileDTO);
        return groupFileMapper.toDto(groupFileRepository.save(groupFile));
    }

    @Override
    public Optional<GroupFileDTO> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public GroupFileDTO findByUuid(String Uuid) {
        GroupFile groupFile = groupFileRepository.findOneByUuid(Uuid);
        return groupFileMapper.toDto(groupFile);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupFileDTO> findAll() {
        return groupFileRepository.findAll()
                .stream().map(groupFileMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupFileDTO> findAllActive() {
        return null;
    }

    @Override
    public void logicalDelete(Integer id) {

    }
}