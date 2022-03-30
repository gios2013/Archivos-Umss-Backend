package org.umss.aub.service.config.impl;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.domain.config.GroupFile;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.dto.config.GroupFileFormDTO;
import org.umss.aub.repository.config.DegreeRepository;
import org.umss.aub.repository.config.GroupFileRepository;
import org.umss.aub.repository.config.TypeFileRepository;
import org.umss.aub.service.config.GroupFileService;
import org.umss.aub.service.config.mapper.DegreeMapper;
import org.umss.aub.service.config.mapper.GroupFileMapper;
import org.umss.aub.service.config.mapper.TypeFileMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupFileServiceImpl implements GroupFileService {

    private final GroupFileMapper groupFileMapper;

    private final GroupFileRepository groupFileRepository;

    private final TypeFileMapper typeFileMapper;

    private final TypeFileRepository typeFileRepository;

    private final DegreeMapper degreeMapper;

    private final DegreeRepository degreeRepository;

    public GroupFileServiceImpl(GroupFileMapper groupFileMapper, GroupFileRepository groupFileRepository, TypeFileMapper typeFileMapper, TypeFileRepository typeFileRepository, DegreeMapper degreeMapper, DegreeRepository degreeRepository) {
        this.groupFileMapper = groupFileMapper;
        this.groupFileRepository = groupFileRepository;
        this.typeFileMapper = typeFileMapper;
        this.typeFileRepository = typeFileRepository;
        this.degreeMapper = degreeMapper;
        this.degreeRepository = degreeRepository;
    }

    @Override
    public GroupFileDTO save(GroupFileDTO groupFileDTO) {
        GroupFile groupFile = groupFileMapper.toEntity(groupFileDTO);
        return groupFileMapper.toDto(groupFileRepository.save(groupFile));
    }

    @Override
    public GroupFileDTO saveForm(GroupFileFormDTO groupFileFormDTO) {
        String typeUuid = groupFileFormDTO.getTypeUuid();

        TypeFile typeFile = typeFileRepository.findOneByUuid(typeUuid);

        GroupFile groupFile = groupFileMapper.getGroupFromForm(groupFileFormDTO, typeFile);

        return groupFileMapper.toDto(groupFileRepository.save(groupFile));
    }

    @Override
    public GroupFileDTO editForm(String Uuid, GroupFileDTO dto){
        GroupFile groupFile = groupFileRepository.findOneByUuid(Uuid);

        groupFile.setGroupnum(dto.getGroupnum());
        groupFile.setMinimumrange(dto.getMinimumrange());
        groupFile.setMaximumrange(dto.getMaximumrange());
        groupFile.setObservation(dto.getObservation());
        groupFile.setYear_initial(dto.getYear_initial());
        groupFileRepository.save(groupFile);

        return groupFileMapper.toDto(groupFile);
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
    public List<DegreeDTO> findAllDegrees(String uuid){
        GroupFile example1 =new GroupFile();
        example1.setGroup_file_id(uuid);
        Optional<GroupFile> optionalTypeFile =groupFileRepository.findOne(Example.of(example1));

        GroupFile groupFile = optionalTypeFile.get();

        Degree example =new Degree();
        GroupFile groupExample = new GroupFile();
        groupExample.setId(groupFile.getId());
        example.setGroupFile(groupExample);

        List<Degree> degrees = degreeRepository.findAll(Example.of(example));
        return degrees.stream().map(degreeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupFileDTO> findAllActive() {
        return null;
    }

    @Override
    public void logicalDelete(Integer id) {
    }

    @Override
    public void deleteGroup(String uuid){
        GroupFile groupFile = groupFileRepository.findOneByUuid(uuid);
        Integer groupId = groupFile.getId();
        groupFileRepository.deleteById(groupId);
    }
}
