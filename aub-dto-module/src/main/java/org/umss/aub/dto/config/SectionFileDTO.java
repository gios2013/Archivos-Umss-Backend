package org.umss.aub.dto.config;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SectionFileDTO {

    private Integer id;
    private String code;
    private String description;
    private Date date_initial;
    private String name;
    private String initials_und;
    private String section_id;
    private Boolean active = Boolean.TRUE;
}
