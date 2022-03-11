package org.umss.aub.service.config.mapper;

import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.Nationality;
import org.umss.aub.domain.config.NationalityType;
import org.umss.aub.domain.config.Student;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.NationalityTypeDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class NationalityTypeMapper implements CustomMapper<NationalityTypeDTO, NationalityType> {
    public final NationalityMapper nationalityMapper;
    public final TypeFileMapper typeFileMapper;

    public NationalityTypeMapper(NationalityMapper nationalityMapper, TypeFileMapper typeFileMapper) {
        this.nationalityMapper = nationalityMapper;
        this.typeFileMapper = typeFileMapper;
    }


    @Override
    public NationalityTypeDTO toDto(NationalityType nationalityType) {
        NationalityTypeDTO dto = new NationalityTypeDTO();
        dto.setId(nationalityType.getId());
        dto.setNationalityDTO(nationalityMapper.toDto(nationalityType.getNationality()));
        dto.setTypeFileDTO(typeFileMapper.toDto(nationalityType.getTypeFile()));
        dto.setActive(nationalityType.getActive());
        return dto;
    }

    @Override
    public NationalityType toEntity(NationalityTypeDTO nationalityTypeDTO) {
        NationalityType nationalityType = new NationalityType();
        nationalityType.setId(nationalityTypeDTO.getId());

        Nationality nationality = nationalityMapper.toEntity(nationalityTypeDTO.getNationalityDTO());
        TypeFile typeFile = typeFileMapper.toEntity(nationalityTypeDTO.getTypeFileDTO());

        nationalityType.setNationality(nationality);
        nationalityType.setTypeFile(typeFile);
        nationalityType.setActive(nationalityTypeDTO.getActive());
        return nationalityType;
    }
}
