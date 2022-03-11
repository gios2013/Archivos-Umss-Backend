package org.umss.aub.service.config.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.Nationality;
import org.umss.aub.domain.config.NationalityType;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.NationalityDTO;
import org.umss.aub.dto.config.NationalityTypeDTO;
import org.umss.aub.dto.config.NationalityTypeFormDTO;
import org.umss.aub.dto.config.TypeFileDTO;
import org.umss.aub.repository.config.NationalityRepository;
import org.umss.aub.repository.config.NationalityTypeRepository;
import org.umss.aub.repository.config.TypeFileRepository;
import org.umss.aub.service.config.NationalityTypeService;
import org.umss.aub.service.config.mapper.NationalityMapper;
import org.umss.aub.service.config.mapper.NationalityTypeMapper;
import org.umss.aub.service.config.mapper.TypeFileMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class NationalityTypeServiceImpl implements NationalityTypeService {

    private final NationalityTypeMapper nationalityTypeMapper;

    private final NationalityTypeRepository nationalityTypeRepository;

    private final TypeFileRepository typeFileRepository;

    private final TypeFileMapper typeFileMapper;

    private final NationalityMapper nationalityMapper;

    private final NationalityRepository nationalityRepository;

    public NationalityTypeServiceImpl(NationalityTypeMapper nationalityTypeMapper, NationalityTypeRepository nationalityTypeRepository, TypeFileRepository typeFileRepository, TypeFileMapper typeFileMapper, NationalityMapper nationalityMapper, NationalityRepository nationalityRepository) {
        this.nationalityTypeMapper = nationalityTypeMapper;
        this.nationalityTypeRepository = nationalityTypeRepository;
        this.typeFileRepository = typeFileRepository;
        this.typeFileMapper = typeFileMapper;
        this.nationalityMapper = nationalityMapper;
        this.nationalityRepository = nationalityRepository;
    }


    @Override
    public List<NationalityTypeDTO> findAll() {
        return nationalityTypeRepository.findAll()
                .stream().map(nationalityTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<NationalityTypeDTO> findAllByBachiller() {
        return null;
    }

    @Override
    public NationalityTypeDTO saveWithFiles(NationalityTypeFormDTO nationalityTypeFormDTO) {
        TypeFile typeFile = typeFileRepository.findOneByUuid(nationalityTypeFormDTO.getType_file());
        NationalityTypeDTO nationalityTypeDTO = new NationalityTypeDTO();
        nationalityTypeDTO.setTypeFileDTO(typeFileMapper.toDto(typeFile));

        NationalityDTO nationalityDTO = new NationalityDTO();
        nationalityDTO.setName(nationalityTypeFormDTO.getName());
        nationalityDTO.setDemonym(nationalityTypeFormDTO.getDemonym());
        nationalityDTO.setCode(nationalityTypeFormDTO.getCode());

        Nationality nationality = nationalityMapper.toEntity(nationalityDTO);

        NationalityDTO dto = nationalityMapper.toDto(nationalityRepository.save(nationality));

        nationalityTypeDTO.setNationalityDTO(dto);
        nationalityTypeDTO.setActive(true);

        NationalityType nationalityType = nationalityTypeMapper.toEntity(nationalityTypeDTO);
        return nationalityTypeMapper.toDto(nationalityTypeRepository.save(nationalityType));
    }

    @Override
    public NationalityTypeDTO getByUuid(String uuid) {
        return null;
    }

    @Override
    public NationalityTypeDTO editById(String uuid, NationalityTypeDTO dto) {
        return null;
    }

    @Override
    public void logicalDelete(Integer id) {
        Optional<NationalityType> nationalityTypeOptional = nationalityTypeRepository.findById(id);
        NationalityType nationalityType = nationalityTypeOptional.get();
        nationalityType.setActive(Boolean.FALSE);
    }

    @Override
    public void logicalEnable(Integer id) {
        Optional<NationalityType> nationalityTypeOptional = nationalityTypeRepository.findById(id);
        NationalityType nationalityType = nationalityTypeOptional.get();
        nationalityType.setActive(Boolean.TRUE);
    }
}
