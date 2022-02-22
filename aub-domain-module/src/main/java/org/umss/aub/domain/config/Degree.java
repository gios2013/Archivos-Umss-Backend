package org.umss.aub.domain.config;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "degree")
@Data
@NoArgsConstructor
public class Degree {
    @Id
    @SequenceGenerator(name = "degree_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String degree_id;
    private Integer degree_num;
    private Date date_initial;
    private String observation;
    private Integer folio_num;
    private Date folio_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeid")
    private TypeFile typeFile;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentid")
    private Student student;

    @OneToMany(mappedBy = "degree")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Attachment> attachmentList;

    @OneToMany(mappedBy = "degree")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<StudentRecord> studentRecords;

    @PrePersist
    public void initializeUuid(){
        this.setDegree_id(UUID.randomUUID().toString());
    }
}
