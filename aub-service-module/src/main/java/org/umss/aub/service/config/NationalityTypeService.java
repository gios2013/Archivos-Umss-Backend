package org.umss.aub.service.config;

import org.umss.aub.dto.config.NationalityTypeDTO;
import org.umss.aub.dto.config.NationalityTypeFormDTO;
import org.umss.aub.service.CrudServiceBase;
import org.umss.aub.service.FormServiceBase;

public interface NationalityTypeService extends FormServiceBase<NationalityTypeFormDTO, NationalityTypeDTO, String, Integer> {
}
