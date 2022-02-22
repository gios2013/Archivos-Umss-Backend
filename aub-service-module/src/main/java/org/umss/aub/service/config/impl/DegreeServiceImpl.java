package org.umss.aub.service.config.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.domain.config.Student;
import org.umss.aub.domain.config.TypeFile;
import org.umss.aub.dto.config.*;
import org.umss.aub.repository.config.DegreeRepository;
import org.umss.aub.repository.config.StudentRepository;
import org.umss.aub.repository.config.TypeFileRepository;
import org.umss.aub.service.config.DegreeAttachmentService;
import org.umss.aub.service.config.DegreeService;
import org.umss.aub.service.config.DegreeStudentRecordService;
import org.umss.aub.service.config.StudentService;
import org.umss.aub.service.config.mapper.DegreeMapper;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class DegreeServiceImpl implements DegreeService {

    private final DegreeMapper degreeMapper;

    private final DegreeRepository degreeRepository;

    private final TypeFileRepository typeFileRepository;

    private final StudentRepository studentRepository;

    private final StudentService studentService;

    private final DegreeAttachmentService degreeAttachmentService;

    private final DegreeStudentRecordService degreeStudentRecordService;

    public DegreeServiceImpl(DegreeMapper degreeMapper, DegreeRepository degreeRepository,
                             TypeFileRepository typeFileRepository, StudentRepository studentRepository,
                             StudentService studentService, DegreeAttachmentService degreeAttachmentService,
                             DegreeStudentRecordService degreeStudentRecordService) {
        this.degreeMapper = degreeMapper;
        this.degreeRepository = degreeRepository;
        this.typeFileRepository = typeFileRepository;
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.degreeAttachmentService = degreeAttachmentService;
        this.degreeStudentRecordService = degreeStudentRecordService;
    }


    @Override
    @Transactional(readOnly = true)
    public List<DegreeDTO> findAll() {
        return degreeRepository.findAll()
                .stream().map(degreeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DegreeDTO> findAllByBachiller() {
        return degreeRepository.findAllByBachiller()
                .stream().map(degreeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DegreeDTO saveWithFiles(DegreeFormDTO degreeFormDTO) {
        String typeUuid = degreeFormDTO.getTypeUuid();

        TypeFile typeFile = typeFileRepository.findOneByUuid(typeUuid);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setCi(degreeFormDTO.getCi());
        studentDTO.setPassport(degreeFormDTO.getPassport());
        studentDTO.setLastname(degreeFormDTO.getLastname());
        studentDTO.setName(degreeFormDTO.getName());
        studentDTO.setGender(degreeFormDTO.getGender());
        studentDTO.setNationality(degreeFormDTO.getNationality());

        StudentDTO est =studentService.save(studentDTO);

        Student student = studentRepository.findOneByUuid(est.getStudent_id());

        Degree degree = degreeMapper.getDegreeFromForm(degreeFormDTO, typeFile, student);

        degreeRepository.save(degree);

        List<AttachmentDTO> attachmentDTO = degreeAttachmentService.save(degree, degreeFormDTO.getAttachment());

        List<StudentRecordDTO> studentRecordDTO = degreeStudentRecordService
                .save(degree, degreeFormDTO.getStudentRecord());

        return degreeMapper.toDto(degree, attachmentDTO, studentRecordDTO);
    }

    @Override
    public DegreeDTO getByUuid(String uuid) {
        Degree degree = degreeRepository.findOneByUuid(uuid);
        List<AttachmentDTO> attachmentDTO = degreeAttachmentService.getById(degree);
        List<StudentRecordDTO> studentRecordDTO = degreeStudentRecordService.getById(degree);
        return degreeMapper.toDto(degree, attachmentDTO,studentRecordDTO);
    }

    @Override
    public void logicalDelte(Integer id) {

    }
}
