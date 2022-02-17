package org.umss.aub.service.config.mapper;

import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.Attachment;
import org.umss.aub.dto.config.AttachmentDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class AttachmentMapper implements CustomMapper<AttachmentDTO, Attachment> {

    private final DegreeMapper degreeMapper;

    public AttachmentMapper(DegreeMapper degreeMapper) {
        this.degreeMapper = degreeMapper;
    }


    @Override
    public AttachmentDTO toDto(Attachment attachment) {
        AttachmentDTO dto = new AttachmentDTO();
        dto.setAttachment_id(attachment.getAttachment_id());
        dto.setName(attachment.getName());
        return dto;
    }

    @Override
    public Attachment toEntity(AttachmentDTO attachmentDTO) {
        Attachment attachment = new Attachment();
        attachment.setAttachment_id(attachmentDTO.getAttachment_id());
        attachment.setName(attachmentDTO.getName());
        attachment.setDegree(degreeMapper.toEntity(attachmentDTO.getDegreeDTO()));
        return attachment;
    }
}
