package org.umss.aub.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class DegreeDTO implements Serializable {

    private Integer id;
    private String degree_id;
    private Integer degree_num;
    private Date date_initial;
    private String observation;
    private Integer folio_num;
    private Date folio_date;

    private TypeFileDTO typeFileDTO;
    private StudentDTO studentDTO;
}
