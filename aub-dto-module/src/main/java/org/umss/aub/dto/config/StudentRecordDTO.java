package org.umss.aub.dto.config;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.nio.file.Path;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class StudentRecordDTO {

    private Integer id;
    private String name;
    @Column(name = "numtitulo")
    private Integer numTitulo;
    private Date register_date;
    private String observation;
    private Long size;
    private String path;
    private String attachment_id;

    private Path file;

    private DegreeDTO degreeDTO;
}
