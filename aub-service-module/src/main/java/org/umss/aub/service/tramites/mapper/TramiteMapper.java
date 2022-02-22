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
        tramitesDTO.setCodigo(tramites.getCod_tre());
        tramitesDTO.setId(tramites.getTre_id());
        tramitesDTO.setNombre(tramites.getTre_nombre());
        tramitesDTO.setTitulo(tramites.getTre_titulo());
        tramitesDTO.setTituloInterno(tramites.getTre_titulo_interno());
        tramitesDTO.setGlosa(tramites.getTre_glosa());
        tramitesDTO.setHab(tramites.getTre_hab());
        tramitesDTO.setDuracion(tramites.getTre_duracion());
        tramitesDTO.setDesc(tramites.getTre_desc());
        tramitesDTO.setCosto(tramites.getTre_costo());
        tramitesDTO.setTipo(tramites.getTre_tipo());
        tramitesDTO.setBuscar_en(tramites.getTre_buscar_en());
        tramitesDTO.setCuenta(tramites.getTre_cuenta());
        return tramitesDTO;
    }

    @Override
    public Tramites toEntity(TramitesDTO tramitesDTO) {
        Tramites tramites = new Tramites();
        tramites.setCod_tre(tramitesDTO.getCodigo());
        tramites.setTre_id(tramitesDTO.getId());
        tramites.setTre_nombre(tramitesDTO.getNombre());
        tramites.setTre_titulo(tramitesDTO.getTitulo());
        tramites.setTre_titulo_interno(tramitesDTO.getTituloInterno());
        tramites.setTre_glosa(tramitesDTO.getGlosa());
        tramites.setTre_hab(tramitesDTO.getHab());
        tramites.setTre_duracion(tramitesDTO.getDuracion());
        tramites.setTre_desc(tramitesDTO.getDesc());
        tramites.setTre_costo(tramitesDTO.getCosto());
        tramites.setTre_tipo(tramitesDTO.getTipo());
        tramites.setTre_buscar_en(tramitesDTO.getBuscar_en());
        tramites.setTre_cuenta(tramitesDTO.getCuenta());
        return tramites;
    }
}
