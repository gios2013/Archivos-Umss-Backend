package org.umss.aub.service;

import org.springframework.core.io.Resource;

import java.net.MalformedURLException;
import java.util.List;

public interface FileSaveBase<DTO, D, F, T, S> {
    List<DTO> save(D degree, List<F> file);
    List<DTO> getById(D degree);
    Resource load(S name) throws MalformedURLException;
}
