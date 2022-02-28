package org.umss.aub.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DegreeFormDTO {

    private Integer degree_num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_initial;
    private String typeUuid;
    private String observation;
    private Integer folio_num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate folio_date;
    private List<MultipartFile> attachment;
    private List<MultipartFile> studentRecord;

    //Estudiante

    private Integer ci;
    private Integer passport;
    private String lastname;
    private String name;
    private String gender;
    private String nationality;
}
