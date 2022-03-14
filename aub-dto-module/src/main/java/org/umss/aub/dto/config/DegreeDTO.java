package org.umss.aub.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class DegreeDTO implements Serializable {

    private Integer id;
    private String degree_id;
    private Integer degree_num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_initial;
    private String observation;
    private Integer folio_num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate folio_date;

    private TypeFileDTO typeFileDTO;
    private StudentDTO studentDTO;
    private GroupFileDTO groupFileDTO;

    private List<AttachmentDTO> attachmentDTOS;
    private List<StudentRecordDTO> studentRecordDTOS;
}
