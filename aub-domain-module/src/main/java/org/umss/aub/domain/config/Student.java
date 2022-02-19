package org.umss.aub.domain.config;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "student_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String student_id;
    private Integer ci;
    private Integer passport;
    private String lastname;
    private String name;
    private String gender;
    private String nationality;

    @PrePersist
    public void initializeUuid(){
        this.setStudent_id(UUID.randomUUID().toString());
    }
}
