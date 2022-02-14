package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umss.aub.domain.config.TypeFile;

public interface TypeFileRepository extends JpaRepository<TypeFile, Integer> {
}
