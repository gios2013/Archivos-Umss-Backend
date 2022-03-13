package org.umss.aub.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class GroupFileFormDTO {

    private Integer id;
    private Integer groupnum;
    private Integer minimumrange;
    private Integer maximumrange;
    private String observation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_initial;
    private String group_file_id;

    private String typeUuid;
}