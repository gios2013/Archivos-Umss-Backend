package org.umss.aub.service;

import java.util.List;

public interface FileSaveBase<DTO, D, F, T> {
    List<DTO> save(D degree, List<F> file);
    List<DTO> getById(D degree);
}
