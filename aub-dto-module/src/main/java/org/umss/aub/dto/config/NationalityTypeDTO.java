package org.umss.aub.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NationalityTypeDTO {
    private Integer id;

    private NationalityDTO nationalityDTO;
    private TypeFileDTO typeFileDTO;

    private Boolean active;
}
