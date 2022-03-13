package org.umss.aub.service.config.impl;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.domain.config.GroupFile;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.dto.config.TypeFileDTO;
import org.umss.aub.repository.config.DegreeRepository;
import org.umss.aub.repository.config.GroupFileRepository;
import org.umss.aub.repository.config.TypeFileRepository;
import org.umss.aub.service.config.TypeFileService;
import org.umss.aub.service.config.mapper.DegreeMapper;
import org.umss.aub.service.config.mapper.GroupFileMapper;
import org.umss.aub.service.config.mapper.TypeFileMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TypeFileServiceImpl implements TypeFileService {

    private final TypeFileRepository typeFileRepository;

    private final TypeFileMapper typeFileMapper;

    private final DegreeRepository degreeRepository;

    private final DegreeMapper degreeMapper;

    private final GroupFileRepository groupFileRepository;

    private final GroupFileMapper groupFileMapper;

    public TypeFileServiceImpl(TypeFileRepository typeFileRepository, TypeFileMapper typeFileMapper, DegreeRepository degreeRepository, DegreeMapper degreeMapper, GroupFileRepository groupFileRepository, GroupFileMapper groupFileMapper) {
        this.typeFileRepository = typeFileRepository;
        this.typeFileMapper = typeFileMapper;
        this.degreeRepository = degreeRepository;
        this.degreeMapper = degreeMapper;
        this.groupFileRepository = groupFileRepository;
        this.groupFileMapper = groupFileMapper;
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
    public List<DegreeDTO> getAllByUuid(String uuid) {
        TypeFile example1 =new TypeFile();
        example1.setType_id(uuid);
        Optional<TypeFile> optionalTypeFile =typeFileRepository.findOne(Example.of(example1));

        TypeFile typeFile = optionalTypeFile.get();

        Degree example =new Degree();
        TypeFile typeExample = new TypeFile();
        typeExample.setId(typeFile.getId());
        example.setTypeFile(typeExample);

        List<Degree> degrees = degreeRepository.findAll(Example.of(example));
        return degrees.stream().map(degreeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupFileDTO> getAllGroupsByUuid(String uuid) {
        TypeFile example1 =new TypeFile();
        example1.setType_id(uuid);
        Optional<TypeFile> optionalTypeFile =typeFileRepository.findOne(Example.of(example1));

        TypeFile typeFile = optionalTypeFile.get();

        GroupFile example = new GroupFile();
        TypeFile typeExample = new TypeFile();
        typeExample.setId(typeFile.getId());
        example.setTypeFile(typeExample);

        List<GroupFile> groupFiles = groupFileRepository.findAll(Example.of(example));
        return groupFiles.stream().map(groupFileMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeFileDTO> findAllActive() {
        return null;
    }

    @Override
    public TypeFileDTO editByUuid(String uuid, TypeFileDTO typeFileDTO) {
        TypeFile typeFile = typeFileRepository.findOneByUuid(uuid);
        TypeFile edit = typeFileMapper.toEntity(typeFileDTO);

        typeFile.setName(edit.getName());
        typeFile.setCode(edit.getCode());
        typeFile.setDescription(edit.getDescription());
        typeFileRepository.save(typeFile);

        return typeFileMapper.toDto(typeFile);
    }

    @Override
    public void logicalDelete(Integer id) {

    }
}
