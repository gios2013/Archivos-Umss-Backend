package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.aub.domain.config.Student;
import org.umss.aub.domain.config.TypeFile;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.student_id = ?1")
    Student findOneByUuid(String uuid);
}
