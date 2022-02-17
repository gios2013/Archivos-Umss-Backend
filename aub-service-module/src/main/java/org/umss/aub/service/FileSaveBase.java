package org.umss.aub.service;

import java.util.List;

public interface FileSaveBase<DTO, D, F> {
    List<DTO> save(D degree, List<F> file);
}
