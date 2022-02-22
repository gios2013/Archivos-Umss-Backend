package org.umss.aub.dto.tramites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TramitesDTO {

    private Integer codigo;
    private String id;
    private String nombre;
    private String titulo;
    private String tituloInterno;
    private String glosa;
    private String hab;
    private String duracion;
    private String desc;
    private Integer costo;
    private String tipo;
    private String buscar_en;
    private Integer cuenta;


}
