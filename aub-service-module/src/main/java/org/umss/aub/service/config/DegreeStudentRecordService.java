package org.umss.aub.service.config;

import org.springframework.web.multipart.MultipartFile;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.dto.config.StudentRecordDTO;
import org.umss.aub.service.FileSaveBase;

public interface DegreeStudentRecordService extends FileSaveBase<StudentRecordDTO, Degree, MultipartFile, Integer, String> {
}
