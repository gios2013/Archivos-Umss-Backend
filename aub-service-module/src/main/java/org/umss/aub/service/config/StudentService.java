package org.umss.aub.service.config;

import org.umss.aub.dto.config.StudentDTO;
import org.umss.aub.service.CrudServiceBase;

public interface StudentService extends CrudServiceBase<StudentDTO, Integer, String> {
    StudentDTO findByCi(Integer ci);
}
