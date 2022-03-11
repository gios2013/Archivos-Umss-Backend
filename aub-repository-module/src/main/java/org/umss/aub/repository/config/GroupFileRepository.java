package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.domain.config.GroupFile;

public interface GroupFileRepository extends JpaRepository<GroupFile, Integer> {

    @Query("select s from GroupFile s where s.group_file_id = ?1")
    GroupFile findOneByUuid(String uuid);
}
