package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umss.aub.domain.config.SectionFile;

public interface SectionFileRepository extends JpaRepository<SectionFile, Integer> {
}
