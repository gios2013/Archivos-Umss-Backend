package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.aub.domain.config.SectionFile;
import org.umss.aub.domain.config.StudentRecord;

public interface StudentRecordRepository extends JpaRepository<StudentRecord, Integer> {
    @Query("select s from StudentRecord s where s.attachment_id = ?1")
    StudentRecord findOneByUuid(String uuid);
}
