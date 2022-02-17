package org.umss.aub.service.config.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umss.aub.domain.config.Student;
import org.umss.aub.dto.config.StudentDTO;
import org.umss.aub.repository.config.StudentRepository;
import org.umss.aub.service.config.StudentService;
import org.umss.aub.service.config.mapper.StudentMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StudentDTO> findById(Integer id) {
        return studentRepository.findById(id).map(studentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDTO findByUuid(String Uuid) {
        Student student = studentRepository.findOneByUuid(Uuid);
        return studentMapper.toDto(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream().map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findAllActive() {
        return null;
    }

    @Override
    public void logicalDelete(Integer id) {

    }
}
