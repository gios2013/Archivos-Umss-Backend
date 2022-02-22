package org.umss.aub.service;

import java.util.List;
import java.util.Optional;

public interface IdServiceBase<DTO, T, S, D> {
    DTO save(DTO dto);
    Optional<DTO> findById(T id);
    DTO findByUuid(S uuid);
    List<DTO> findAll();
    List<D> getAllByUuid(S uuid);
    List<DTO> findAllActive();
    DTO editByUuid(S uuid, DTO dto);
    void logicalDelete(T id);
}
