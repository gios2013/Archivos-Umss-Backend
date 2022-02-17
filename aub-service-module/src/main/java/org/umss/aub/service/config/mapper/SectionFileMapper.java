package org.umss.aub.service.config.mapper;


import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.SectionFile;
import org.umss.aub.dto.config.SectionFileDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class SectionFileMapper implements CustomMapper<SectionFileDTO, SectionFile> {

    @Override
    public SectionFileDTO toDto(SectionFile sectionFile) {
        SectionFileDTO dto = new SectionFileDTO();
        dto.setId(sectionFile.getId());
        dto.setCode(sectionFile.getCode());
        dto.setDescription(sectionFile.getDescription());
        dto.setDate_initial(sectionFile.getDate_initial());
        dto.setName(sectionFile.getName());
        dto.setInitials_und(sectionFile.getInitials_und());
        dto.setSection_id(sectionFile.getSection_id());
        dto.setActive(sectionFile.getActive());
        return dto;
    }

    @Override
    public SectionFile toEntity(SectionFileDTO sectionFileDTO) {
        SectionFile sectionFile = new SectionFile();
        sectionFile.setId(sectionFileDTO.getId());
        sectionFile.setCode(sectionFileDTO.getCode());
        sectionFile.setDescription(sectionFileDTO.getDescription());
        sectionFile.setDate_initial(sectionFileDTO.getDate_initial());
        sectionFile.setName(sectionFileDTO.getName());
        sectionFile.setInitials_und(sectionFileDTO.getInitials_und());
        sectionFile.setSection_id(sectionFileDTO.getSection_id());
        sectionFile.setActive(sectionFileDTO.getActive());
        return sectionFile;
    }
}
