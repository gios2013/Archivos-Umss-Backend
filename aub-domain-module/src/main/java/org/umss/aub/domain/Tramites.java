package org.umss.aub.domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="tramites")
public class Tramites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cod_tre;
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
    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date updated_at;

    public Tramites() {
    }


}
