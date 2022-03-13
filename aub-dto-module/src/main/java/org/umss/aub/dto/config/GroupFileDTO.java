package org.umss.aub.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GroupFileDTO {

    private Integer id;
    private Integer groupnum;
    private Integer minimumrange;
    private Integer maximumrange;
    private String observation;
    private Integer year_initial;
    private String group_file_id;

    private TypeFileDTO typeFileDTO;

}
