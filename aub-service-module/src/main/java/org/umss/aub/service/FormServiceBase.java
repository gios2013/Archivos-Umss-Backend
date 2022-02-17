package org.umss.aub.service;

import java.util.List;
import java.util.Optional;

public interface FormServiceBase<DTO, D, S> {

    D saveWithFiles(DTO dto);
}
