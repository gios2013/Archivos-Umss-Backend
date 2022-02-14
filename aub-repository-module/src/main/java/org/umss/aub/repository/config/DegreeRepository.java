package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umss.aub.domain.config.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
}
