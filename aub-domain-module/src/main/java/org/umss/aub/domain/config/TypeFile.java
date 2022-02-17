package org.umss.aub.domain.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "type_file")
@Data
@NoArgsConstructor
public class TypeFile {
    @Id
    @SequenceGenerator(name = "type_file_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private String description;
    private String type_id;
}
