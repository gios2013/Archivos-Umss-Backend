package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umss.aub.domain.config.NationalityType;

public interface NationalityTypeRepository extends JpaRepository<NationalityType, Integer> {
}
