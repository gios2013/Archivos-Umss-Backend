package org.umss.aub.repository.tramites;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umss.aub.domain.tramites.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

}
