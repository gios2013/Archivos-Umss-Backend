package org.umss.aub.dto.config;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.umss.aub.domain.config.Degree;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AttachmentDTO {

    private Integer id;
    private String name;
    @Column(name = "numtitulo")
    private Integer numTitulo;
    private Date register_date;
    private String observation;
    private Long size;
    private String path;
    private String attachment_id;

    private DegreeDTO degreeDTO;
}
