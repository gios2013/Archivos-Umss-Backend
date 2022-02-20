package org.umss.aub.service.tramites.mapper;


import org.springframework.stereotype.Component;
import org.umss.aub.domain.tramites.Tramites;
import org.umss.aub.dto.tramites.TramitesDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class TramiteMapper implements CustomMapper<TramitesDTO, Tramites> {


    @Override
    public TramitesDTO toDto(Tramites tramites) {
        TramitesDTO tramitesDTO = new TramitesDTO();
        tramitesDTO.setCod_tre(tramites.getCod_tre());
        tramitesDTO.setTre_id(tramites.getTre_id());
        tramitesDTO.setTre_nombre(tramites.getTre_nombre());
        tramitesDTO.setTre_titulo(tramites.getTre_titulo());
        tramitesDTO.setTre_titulo_interno(tramites.getTre_titulo_interno());
        tramitesDTO.setTre_glosa(tramites.getTre_glosa());
        tramitesDTO.setTre_hab(tramites.getTre_hab());
        tramitesDTO.setTre_duracion(tramites.getTre_duracion());
        tramitesDTO.setTre_desc(tramites.getTre_desc());
        tramitesDTO.setTre_costo(tramites.getTre_costo());
        tramitesDTO.setTre_tipo(tramites.getTre_tipo());
        tramitesDTO.setTre_buscar_en(tramites.getTre_buscar_en());
        tramitesDTO.setTre_cuenta(tramites.getTre_cuenta());
        return tramitesDTO;
    }

    @Override
    public Tramites toEntity(TramitesDTO tramitesDTO) {
        Tramites tramites = new Tramites();
        tramites.setCod_tre(tramitesDTO.getCod_tre());
        tramites.setTre_id(tramitesDTO.getTre_id());
        tramites.setTre_nombre(tramitesDTO.getTre_nombre());
        tramites.setTre_titulo(tramitesDTO.getTre_titulo());
        tramites.setTre_titulo_interno(tramitesDTO.getTre_titulo_interno());
        tramites.setTre_glosa(tramitesDTO.getTre_glosa());
        tramites.setTre_hab(tramitesDTO.getTre_hab());
        tramites.setTre_duracion(tramitesDTO.getTre_duracion());
        tramites.setTre_desc(tramitesDTO.getTre_desc());
        tramites.setTre_costo(tramitesDTO.getTre_costo());
        tramites.setTre_tipo(tramitesDTO.getTre_tipo());
        tramites.setTre_buscar_en(tramitesDTO.getTre_buscar_en());
        tramites.setTre_cuenta(tramitesDTO.getTre_cuenta());
        return tramites;
    }
}
