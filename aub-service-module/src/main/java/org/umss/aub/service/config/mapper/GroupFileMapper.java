package org.umss.aub.service.config.mapper;

import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.GroupFile;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.dto.config.GroupFileFormDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class GroupFileMapper implements CustomMapper<GroupFileDTO, GroupFile> {

    private final TypeFileMapper typeFileMapper;

    public GroupFileMapper(TypeFileMapper typeFileMapper) {
        this.typeFileMapper = typeFileMapper;
    }

    @Override
    public GroupFileDTO toDto(GroupFile groupFile) {
        GroupFileDTO dto = new GroupFileDTO();
        dto.setId(groupFile.getId());
        dto.setGroupnum(groupFile.getGroupnum());
        dto.setMinimumrange(groupFile.getMinimumrange());
        dto.setMaximumrange(groupFile.getMaximumrange());
        dto.setObservation(groupFile.getObservation());
        dto.setYear_initial(groupFile.getYear_initial());
        dto.setGroup_file_id(groupFile.getGroup_file_id());
        dto.setTypeFileDTO(typeFileMapper.toDto(groupFile.getTypeFile()));
        return dto;
    }

    @Override
    public GroupFile toEntity(GroupFileDTO groupFileDTO) {
        GroupFile groupFile = new GroupFile();
        groupFile.setId(groupFileDTO.getId());
        groupFile.setGroupnum(groupFileDTO.getGroupnum());
        groupFile.setMinimumrange(groupFileDTO.getMinimumrange());
        groupFile.setMaximumrange(groupFileDTO.getMaximumrange());
        groupFile.setObservation(groupFileDTO.getObservation());
        groupFile.setYear_initial(groupFileDTO.getYear_initial());
        groupFile.setGroup_file_id(groupFileDTO.getGroup_file_id());

        TypeFile typeFile = typeFileMapper.toEntity(groupFileDTO.getTypeFileDTO());
        groupFile.setTypeFile(typeFile);

        return groupFile;
    }


    public GroupFile getGroupFromForm(GroupFileFormDTO groupFileFormDTO, TypeFile typeFile) {
        GroupFile groupFile = new GroupFile();
        groupFile.setId(groupFileFormDTO.getId());
        groupFile.setGroupnum(groupFileFormDTO.getGroupnum());
        groupFile.setMinimumrange(groupFileFormDTO.getMinimumrange());
        groupFile.setMaximumrange(groupFileFormDTO.getMaximumrange());
        groupFile.setObservation(groupFileFormDTO.getObservation());
        groupFile.setYear_initial(groupFileFormDTO.getYear_initial());
        groupFile.setGroup_file_id(groupFileFormDTO.getGroup_file_id());
        groupFile.setTypeFile(typeFile);
        return groupFile;
    }
}
