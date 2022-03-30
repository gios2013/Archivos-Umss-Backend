package org.umss.aub.dto.config;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String student_id;
    private Integer ci;
    private String passport;
    private String lastname;
    private String name;
    private String gender;
    private String nationality;
}
