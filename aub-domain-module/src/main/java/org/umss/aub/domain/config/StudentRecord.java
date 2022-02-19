package org.umss.aub.domain.config;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_record")
@Data
@NoArgsConstructor
public class StudentRecord {

    @Id
    @SequenceGenerator(name = "student_record_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "numtitulo")
    private Integer numTitulo;
    private Date register_date;
    private String observation;
    private Long size;
    private String path;
    private String attachment_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degreeid")
    private Degree degree;
}
