package org.umss.aub.web.rest.tramites;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.umss.aub.dto.tramites.TramitesDTO;
import org.umss.aub.service.tramites.TramiteService;
import java.util.List;


@RestController
@RequestMapping("v1/tramites/configTramites")
public class TramiteResource {

    private final Logger log = LoggerFactory.getLogger(TramiteResource.class);

    private final TramiteService tramiteService;

    public TramiteResource(TramiteService tramiteService) {
        this.tramiteService = tramiteService;
    }

    @GetMapping
    public List<TramitesDTO> getTramites(){
        log.info("Obteniendo Todos Los Tramites");
        return tramiteService.findAll();
    }

    @PostMapping
    public TramitesDTO saveTramite(@RequestBody TramitesDTO tramitesDTO){
        return tramiteService.save(tramitesDTO);
    }

    @GetMapping("/{tramiteUuid}")
    public TramitesDTO getOneByUuid(@PathVariable String tramiteUuid){
        return tramiteService.findByUuid(tramiteUuid);
    }


}
