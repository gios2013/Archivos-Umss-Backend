package org.umss.aub.service;

import java.util.List;
import java.util.Optional;

public interface CrudServiceBase<DTO, T, S> {
    DTO save(DTO dto);
    Optional<DTO> findById(T id);
    DTO findByUuid(S Uuid);
    List<DTO> findAll();
    List<DTO> findAllActive();
    void logicalDelete(T id);
}
