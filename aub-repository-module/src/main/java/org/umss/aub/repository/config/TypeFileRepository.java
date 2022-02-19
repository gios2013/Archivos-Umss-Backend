package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.aub.domain.config.SectionFile;
import org.umss.aub.domain.config.TypeFile;

public interface TypeFileRepository extends JpaRepository<TypeFile, Integer> {
    @Query("select s from TypeFile s where s.type_id = ?1")
    TypeFile findOneByUuid(String uuid);
}
