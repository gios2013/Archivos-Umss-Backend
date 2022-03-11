package org.umss.aub.domain.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "nationality_type")
@Data
@NoArgsConstructor
public class NationalityType {

    @Id
    @SequenceGenerator(name = "nationality_type_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nationality")
    private Nationality nationality;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type")
    private TypeFile typeFile;
    private Boolean active ;


}
