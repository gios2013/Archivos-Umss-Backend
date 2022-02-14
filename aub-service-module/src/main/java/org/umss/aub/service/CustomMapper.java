package org.umss.aub.service;

public interface CustomMapper<DTO, E> {
    DTO toDto(E e);
    E toEntity(DTO dto);
}
