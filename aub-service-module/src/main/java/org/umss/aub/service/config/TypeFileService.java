package org.umss.aub.service.config;

import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.dto.config.TypeFileDTO;
import org.umss.aub.service.CrudServiceBase;
import org.umss.aub.service.IdServiceBase;

import java.util.List;

public interface TypeFileService extends IdServiceBase<TypeFileDTO, Integer, String, DegreeDTO> {
    List<GroupFileDTO> getAllGroupsByUuid(String uuid);
}
