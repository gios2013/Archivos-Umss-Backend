package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.aub.domain.config.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
    @Query("select s from Degree s where s.degree_id = ?1")
    Degree findOneByUuid(String uuid);
}
