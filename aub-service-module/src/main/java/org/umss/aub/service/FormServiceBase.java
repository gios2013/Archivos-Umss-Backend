package org.umss.aub.service;

import java.util.List;
import java.util.Optional;

public interface FormServiceBase<DTO, D, S> {
    List<D> findAll();
    List<D> findAllByBachiller();
    D saveWithFiles(DTO dto);
}
