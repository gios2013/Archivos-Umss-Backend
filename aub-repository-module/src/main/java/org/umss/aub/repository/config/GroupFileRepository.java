package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umss.aub.domain.config.GroupFile;

public interface GroupFileRepository extends JpaRepository<GroupFile, Integer> {
}
