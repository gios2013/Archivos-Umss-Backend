package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.aub.domain.config.SectionFile;

public interface SectionFileRepository extends JpaRepository<SectionFile, Integer> {
    @Query("select s from SectionFile s where s.section_id = ?1")
    SectionFile findOneByUuid(String uuid);
}
