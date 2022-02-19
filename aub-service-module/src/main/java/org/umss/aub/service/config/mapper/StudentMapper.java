package org.umss.aub.service.config.mapper;

import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.Student;
import org.umss.aub.dto.config.StudentDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class StudentMapper implements CustomMapper<StudentDTO, Student> {
    @Override
    public StudentDTO toDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setStudent_id(student.getStudent_id());
        dto.setCi(student.getCi());
        dto.setPassport(student.getPassport());
        dto.setLastname(student.getLastname());
        dto.setName(student.getName());
        dto.setGender(student.getGender());
        dto.setNationality(student.getNationality());
        return dto;
    }

    @Override
    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setStudent_id(studentDTO.getStudent_id());
        student.setCi(studentDTO.getCi());
        student.setPassport(studentDTO.getPassport());
        student.setLastname(studentDTO.getLastname());
        student.setName(studentDTO.getName());
        student.setGender(studentDTO.getGender());
        student.setNationality(studentDTO.getNationality());
        return student;
    }
}
