package org.umss.aub.service.config;

import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.dto.config.GroupFileFormDTO;
import org.umss.aub.service.CrudServiceBase;
import org.umss.aub.service.FormServiceBase;

import java.util.List;

public interface GroupFileService extends CrudServiceBase<GroupFileDTO, Integer, String> {
    GroupFileDTO saveForm(GroupFileFormDTO groupFileFormDTO);

    GroupFileDTO editForm(String Uuid, GroupFileDTO dto);

    List<DegreeDTO> findAllDegrees(String uuid);

    void deleteGroup(String uuid);
}
