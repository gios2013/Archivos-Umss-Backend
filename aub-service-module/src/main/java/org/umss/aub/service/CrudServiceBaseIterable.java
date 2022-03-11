package org.umss.aub.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CrudServiceBaseIterable<DTO, T, S> {
    DTO save(DTO dto);
    Optional<DTO> findById(T id);
    DTO findByUuid(S Uuid);
    Page<DTO> findAll(Pageable pageable);
    List<DTO> findAllActive();
    DTO editById(T id, DTO dto);
    void logicalDelete(T id);
}
