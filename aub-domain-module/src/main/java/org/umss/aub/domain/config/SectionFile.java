package org.umss.aub.domain.config;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "section_file")
@Data
@NoArgsConstructor
public class SectionFile {

    @Id
    @SequenceGenerator(name = "section_file_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String description;
    private Date date_initial;
    private String name;
    private String initials_und;
    private String section_id;
    private Boolean active;
}
