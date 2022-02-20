package org.umss.aub.domain.config;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "nationality")
@Data
@NoArgsConstructor
public class Nationality {
    @Id
    @SequenceGenerator(name = "nationality_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String demonym;
    private String code;
}
