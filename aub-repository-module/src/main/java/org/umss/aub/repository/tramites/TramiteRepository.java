package org.umss.aub.repository.tramites;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.aub.domain.config.Student;
import org.umss.aub.domain.tramites.Tramites;

public interface TramiteRepository extends JpaRepository<Tramites,Integer> {
    @Query("select t from Tramites t where t.tre_id = ?1")
    Tramites findOneByUuid(String uuid);
}
