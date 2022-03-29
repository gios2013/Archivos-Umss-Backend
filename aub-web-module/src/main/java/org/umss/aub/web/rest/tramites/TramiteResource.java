package org.umss.aub.web.rest.tramites;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umss.aub.dto.tramites.TramitesDTO;
import org.umss.aub.service.tramites.TramiteService;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("v1/tramites/configTramites")
public class TramiteResource {

    private final Logger log = LoggerFactory.getLogger(TramiteResource.class);

    private final TramiteService tramiteService;

    public TramiteResource(TramiteService tramiteService) {
        this.tramiteService = tramiteService;
    }

    @GetMapping
    public List<TramitesDTO> getTramites(@RequestParam(name = "active",defaultValue = "true") boolean active){
        log.info("Obteniendo Todos Los Tramites");
        if (active){
            return tramiteService.findAllActive();
        }else {
            return tramiteService.findAll();
        }
    }

    @PostMapping
    public TramitesDTO saveTramite(@RequestBody TramitesDTO tramitesDTO){
        log.info("Guardando tramites {}", tramitesDTO);
        return tramiteService.save(tramitesDTO);
    }

    @GetMapping("/{tramiteUuid}")
    public TramitesDTO getOneByUuid(@PathVariable String tramiteUuid){
        return tramiteService.findByUuid(tramiteUuid);
    }

    @PutMapping("/{tramiteUuid}")
    public TramitesDTO updateTramite(@PathVariable String tramiteUuid,@RequestBody TramitesDTO tramitesDTO){

            if (tramitesDTO.getId() == null){
                return null;
            }
            if (!Objects.equals(tramiteUuid,tramitesDTO.getId())){
                return null;
            }
            return tramiteService.save(tramitesDTO);
    }

    @DeleteMapping("/{tramiteUuid}")
    public ResponseEntity<Void> logicalDeleteTramite(@PathVariable String tramiteUuid){
        TramitesDTO tramitesDTO = tramiteService.findByUuid(tramiteUuid);
        if (tramitesDTO == null) {
            return null;
        }

        tramiteService.logicalDelete(tramitesDTO.getCodigo());
        return ResponseEntity.noContent().build();
    }


}
