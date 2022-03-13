package org.umss.aub.service.config;

import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.dto.config.GroupFileFormDTO;
import org.umss.aub.service.CrudServiceBase;
import org.umss.aub.service.FormServiceBase;

public interface GroupFileService extends CrudServiceBase<GroupFileDTO, Integer, String> {
    GroupFileDTO saveForm(GroupFileFormDTO groupFileFormDTO);
}
