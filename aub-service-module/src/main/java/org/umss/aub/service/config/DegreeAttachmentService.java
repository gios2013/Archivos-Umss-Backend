package org.umss.aub.service.config;

import org.springframework.web.multipart.MultipartFile;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.dto.config.AttachmentDTO;
import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.service.FileSaveBase;

public interface DegreeAttachmentService extends FileSaveBase<AttachmentDTO, Degree, MultipartFile, Integer> {
}
