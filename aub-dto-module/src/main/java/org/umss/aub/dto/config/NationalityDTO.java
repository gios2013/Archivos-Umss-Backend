package org.umss.aub.dto.config;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NationalityDTO {
    private Integer id;
    private String name;
    private String demonym;
    private String code;
}
