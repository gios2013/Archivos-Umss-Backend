package org.umss.aub.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeFileDTO {
    private Integer id;
    private String name;
    private String code;
    private String description;
    private String type_id;
}
