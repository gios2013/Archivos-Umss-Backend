package org.umss.aub.service.config.mapper;

import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.StudentRecord;
import org.umss.aub.dto.config.StudentRecordDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class StudentRecordMapper implements CustomMapper<StudentRecordDTO, StudentRecord> {

    public final DegreeMapper degreeMapper;

    public StudentRecordMapper(DegreeMapper degreeMapper) {
        this.degreeMapper = degreeMapper;
    }


    @Override
    public StudentRecordDTO toDto(StudentRecord studentRecord) {
        StudentRecordDTO dto = new StudentRecordDTO();
        dto.setAttachment_id(studentRecord.getAttachment_id());
        dto.setName(studentRecord.getName());
        dto.setPath(studentRecord.getPath());
        return dto;
    }

    @Override
    public StudentRecord toEntity(StudentRecordDTO studentRecordDTO) {
        StudentRecord studentRecord = new StudentRecord();
        studentRecord.setAttachment_id(studentRecordDTO.getAttachment_id());
        studentRecord.setName(studentRecordDTO.getName());
        studentRecord.setDegree(degreeMapper.toEntity(studentRecordDTO.getDegreeDTO()));
        return studentRecord;
    }
}
