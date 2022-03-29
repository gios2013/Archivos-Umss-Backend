package org.umss.aub.domain.tramites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="tramites")
@Data
@NoArgsConstructor
public class Tramites {
    @Id
    @SequenceGenerator(name = "tramite_cod_tre_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Date created_at;
    private Date updated_at;
    private Boolean active;
    @PrePersist
    public void initializeUuid(){
        this.setTre_id(UUID.randomUUID().toString());
    }

}
