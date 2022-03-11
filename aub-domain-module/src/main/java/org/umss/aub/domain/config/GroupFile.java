package org.umss.aub.domain.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "group_file")
@Data
@NoArgsConstructor
public class GroupFile {
    @Id
    @SequenceGenerator(name = "group_file_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer groupnum;
    private Integer minimumrange;
    private Integer maximumrange;
    private String observation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_initial;
    private String group_file_id;
}
