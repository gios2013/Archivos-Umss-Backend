package org.umss.aub.service.config.mapper;

import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.GroupFile;
import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class GroupFileMapper implements CustomMapper<GroupFileDTO, GroupFile> {
    @Override
    public GroupFileDTO toDto(GroupFile groupFile) {
        GroupFileDTO dto = new GroupFileDTO();
        dto.setId(groupFile.getId());
        dto.setGroupnum(groupFile.getGroupnum());
        dto.setMinimumrange(groupFile.getMinimumrange());
        dto.setMaximumrange(groupFile.getMaximumrange());
        dto.setObservation(groupFile.getObservation());
        dto.setDate_initial(groupFile.getDate_initial());
        dto.setGroup_file_id(groupFile.getGroup_file_id());
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
        groupFile.setDate_initial(groupFileDTO.getDate_initial());
        groupFile.setGroup_file_id(groupFileDTO.getGroup_file_id());
        return groupFile;
    }
}
