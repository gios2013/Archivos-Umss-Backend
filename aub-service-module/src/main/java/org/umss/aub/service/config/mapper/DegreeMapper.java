package org.umss.aub.service.config.mapper;

import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.domain.config.Student;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.AttachmentDTO;
import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.DegreeFormDTO;
import org.umss.aub.dto.config.StudentRecordDTO;
import org.umss.aub.service.CustomMapper;

import java.util.List;

@Component
public class DegreeMapper implements CustomMapper<DegreeDTO, Degree> {

    private final TypeFileMapper typeFileMapper;

    private final StudentMapper studentMapper;

    public DegreeMapper(TypeFileMapper typeFileMapper, StudentMapper studentMapper) {
        this.typeFileMapper = typeFileMapper;
        this.studentMapper = studentMapper;
    }


    @Override
    public DegreeDTO toDto(Degree degree) {
        DegreeDTO dto = new DegreeDTO();
        dto.setId(degree.getId());
        dto.setDegree_id(degree.getDegree_id());
        dto.setDegree_num(degree.getDegree_num());
        dto.setDate_initial(degree.getDate_initial());
        dto.setObservation(degree.getObservation());
        dto.setFolio_num(degree.getFolio_num());
        dto.setFolio_date(degree.getFolio_date());
        dto.setTypeFileDTO(typeFileMapper.toDto(degree.getTypeFile()));
        dto.setStudentDTO(studentMapper.toDto(degree.getStudent()));
        return dto;
    }

    @Override
    public Degree toEntity(DegreeDTO degreeDTO) {
        Degree degree = new Degree();
        degree.setId(degreeDTO.getId());
        degree.setDegree_id(degreeDTO.getDegree_id());
        degree.setDegree_num(degreeDTO.getDegree_num());
        degree.setDate_initial(degreeDTO.getDate_initial());
        degree.setObservation(degreeDTO.getObservation());
        degree.setFolio_num(degreeDTO.getFolio_num());
        degree.setFolio_date(degreeDTO.getFolio_date());

        TypeFile typeFile = typeFileMapper.toEntity(degreeDTO.getTypeFileDTO());
        Student student = studentMapper.toEntity(degreeDTO.getStudentDTO());

        degree.setTypeFile(typeFile);
        degree.setStudent(student);
        return degree;
    }


    public Degree getDegreeFromForm(DegreeFormDTO degreeFormDTO, TypeFile typeFile, Student student) {
        Degree degree = new Degree();
        degree.setDegree_num(degreeFormDTO.getDegree_num());
        degree.setDate_initial(degreeFormDTO.getDate_initial());
        degree.setObservation(degreeFormDTO.getObservation());
        degree.setFolio_num(degreeFormDTO.getFolio_num());
        degree.setFolio_date(degreeFormDTO.getFolio_date());
        degree.setTypeFile(typeFile);
        degree.setStudent(student);
        return degree;
    }

    public DegreeDTO toDto(Degree degree, List<AttachmentDTO> attachmentDTO, List<StudentRecordDTO> studentRecordDTO) {
        DegreeDTO dto = new DegreeDTO();
        dto.setDegree_id(degree.getDegree_id());
        dto.setDegree_num(degree.getDegree_num());
        dto.setDate_initial(degree.getDate_initial());
        dto.setTypeFileDTO(typeFileMapper.toDto(degree.getTypeFile()));
        dto.setStudentDTO(studentMapper.toDto(degree.getStudent()));
        return dto;
    }
}
