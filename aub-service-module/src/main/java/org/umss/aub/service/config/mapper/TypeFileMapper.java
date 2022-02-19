package org.umss.aub.service.config.mapper;

import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.TypeFileDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class TypeFileMapper implements CustomMapper<TypeFileDTO, TypeFile> {
    @Override
    public TypeFileDTO toDto(TypeFile typeFile) {
        TypeFileDTO dto = new TypeFileDTO();
        dto.setId(typeFile.getId());
        dto.setName(typeFile.getName());
        dto.setCode(typeFile.getCode());
        dto.setDescription(typeFile.getDescription());
        dto.setType_id(typeFile.getType_id());
        return dto;
    }

    @Override
    public TypeFile toEntity(TypeFileDTO typeFileDTO) {
        TypeFile typeFile = new TypeFile();
        typeFile.setId(typeFileDTO.getId());
        typeFile.setName(typeFileDTO.getName());
        typeFile.setCode(typeFileDTO.getCode());
        typeFile.setDescription(typeFileDTO.getDescription());
        typeFile.setType_id(typeFile.getType_id());
        return typeFile;
    }
}
