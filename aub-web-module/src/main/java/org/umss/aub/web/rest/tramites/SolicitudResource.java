package org.umss.aub.web.rest.tramites;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.umss.aub.dto.tramites.SolicitudDTO;
import org.umss.aub.service.tramites.SolicitudService;

import java.util.List;

@RestController
@RequestMapping("v1/tramites/solicitudes")
public class SolicitudResource {

    private final SolicitudService solicitudService;

    public SolicitudResource(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public List<SolicitudDTO> list() {
        return this.solicitudService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public SolicitudDTO create(@RequestBody SolicitudDTO solicitudDTO) {
        return this.solicitudService.create(solicitudDTO);
    }

    @GetMapping("/{id}")
    public SolicitudDTO get(@PathVariable("id") Long id) {
        return this.solicitudService.get(id);
    }


}
