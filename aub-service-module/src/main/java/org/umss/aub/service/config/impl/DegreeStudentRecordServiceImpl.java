package org.umss.aub.service.config.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.umss.aub.domain.config.Attachment;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.domain.config.StudentRecord;
import org.umss.aub.dto.config.AttachmentDTO;
import org.umss.aub.dto.config.StudentRecordDTO;
import org.umss.aub.repository.config.StudentRecordRepository;
import org.umss.aub.service.config.DegreeStudentRecordService;
import org.umss.aub.service.config.mapper.StudentRecordMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DegreeStudentRecordServiceImpl implements DegreeStudentRecordService {

    private final Path root = Paths.get("aub-files-module/src/main/java/org/umss/aub/files/records");

    private final StudentRecordRepository studentRecordRepository;

    private final StudentRecordMapper studentRecordMapper;

    public DegreeStudentRecordServiceImpl(StudentRecordRepository studentRecordRepository, StudentRecordMapper studentRecordMapper) {
        this.studentRecordRepository = studentRecordRepository;
        this.studentRecordMapper = studentRecordMapper;
    }


    @Override
    public List<StudentRecordDTO> save(Degree degree, List<MultipartFile> file) {
        List<StudentRecordDTO> recordDTOList = new ArrayList<>();

        for (MultipartFile fil : file){
            Path filePath = this.root.resolve(fil.getOriginalFilename());
            StudentRecord studentRecord = new StudentRecord();
            studentRecord.setDegree(degree);
            studentRecord.setName(fil.getOriginalFilename());
            studentRecord.setNumTitulo(degree.getDegree_num());
            studentRecord.setSize(fil.getSize());
            studentRecord.setPath(filePath.toString());

            studentRecordRepository.save(studentRecord);

            try {
                Files.copy(fil.getInputStream(), filePath);
            } catch (Exception e) {
                throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
            }

            recordDTOList.add(studentRecordMapper.toDto(studentRecord));
        }
        return recordDTOList;
    }
}
