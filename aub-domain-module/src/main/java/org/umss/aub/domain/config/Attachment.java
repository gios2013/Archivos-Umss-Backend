package org.umss.aub.domain.config;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.net.URI;
import java.util.Date;

@Entity
@Table(name = "attachment")
@Data
@NoArgsConstructor
public class Attachment {

    @Id
    @SequenceGenerator(name = "attachment_id_seq")
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
    @Transient
    private URI file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degreeid")
    private Degree degree;
}
