package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umss.aub.domain.config.Student;

public interface StudentRespository extends JpaRepository<Student, Integer> {
}
