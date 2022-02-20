package org.umss.aub.dto.tramites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TramitesDTO {

    private Integer cod_tre;
    private String tre_id;
    private String tre_nombre;
    private String tre_titulo;
    private String tre_titulo_interno;
    private String tre_glosa;
    private String tre_hab;
    private String tre_duracion;
    private String tre_desc;
    private Integer tre_costo;
    private String tre_tipo;
    private String tre_buscar_en;
    private Integer tre_cuenta;


}
