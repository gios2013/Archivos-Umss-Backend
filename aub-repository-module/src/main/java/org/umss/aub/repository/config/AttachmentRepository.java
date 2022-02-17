package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.aub.domain.config.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
    @Query("select s from Attachment s where s.attachment_id = ?1")
    Attachment findOneByUuid(String uuid);
}
