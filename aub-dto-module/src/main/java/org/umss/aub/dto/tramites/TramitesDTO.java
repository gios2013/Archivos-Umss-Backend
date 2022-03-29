package org.umss.aub.dto.tramites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TramitesDTO implements Serializable {

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
    private Boolean active = Boolean.TRUE;



}
