package org.umss.aub.service.config;

import org.umss.aub.domain.config.Degree;
import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.DegreeFormDTO;
import org.umss.aub.service.CrudServiceBase;
import org.umss.aub.service.FormServiceBase;

public interface DegreeService extends FormServiceBase<DegreeFormDTO, DegreeDTO, String> {
}
