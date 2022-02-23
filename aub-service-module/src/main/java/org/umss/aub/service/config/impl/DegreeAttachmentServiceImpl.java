package org.umss.aub.service.config.impl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.umss.aub.domain.config.Attachment;
import org.umss.aub.domain.config.Degree;
import org.umss.aub.dto.config.AttachmentDTO;
import org.umss.aub.dto.config.StudentRecordDTO;
import org.umss.aub.repository.config.AttachmentRepository;
import org.umss.aub.service.config.DegreeAttachmentService;
import org.umss.aub.service.config.mapper.AttachmentMapper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class DegreeAttachmentServiceImpl implements DegreeAttachmentService {

    private final Path root = Paths.get("aub-files-module/src/main/java/org/umss/aub/files/degree");
    private final Path root2 = Paths.get("antecedentes");

    private final AttachmentMapper attachmentMapper;

    private final AttachmentRepository attachmentRepository;

    public DegreeAttachmentServiceImpl(AttachmentMapper attachmentMapper, AttachmentRepository attachmentRepository) {
        this.attachmentMapper = attachmentMapper;
        this.attachmentRepository = attachmentRepository;
    }

    public void init() {
        try {
            FileSystemUtils.deleteRecursively(root.toFile());
            FileSystemUtils.deleteRecursively(root2.toFile());
            Files.createDirectory(root);
            Files.createDirectory(root2);
        } catch(IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public List<AttachmentDTO> save(Degree degree, List<MultipartFile> file) {
        List<AttachmentDTO> recordDTOList = new ArrayList<>();

        for (MultipartFile fil : file){
            Path filePath = this.root.resolve(fil.getOriginalFilename());
            Attachment attachment = new Attachment();
            attachment.setDegree(degree);
            attachment.setNumTitulo(degree.getDegree_num());
            attachment.setName(fil.getOriginalFilename());
            attachment.setSize(fil.getSize());
            attachment.setPath(filePath.toString());

            attachmentRepository.save(attachment);

            try {
                Files.copy(fil.getInputStream(), filePath);
            } catch (Exception e) {
                throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
            }

            recordDTOList.add(attachmentMapper.toDto(attachment));
        }
        return recordDTOList;
    }

    @Override
    public List<AttachmentDTO> getById(Degree degree) {
//        List<Attachment> attachmentList = attachmentRepository.findAllByIdDegree(id);
//        return attachmentList.stream()
//                .map(attachmentMapper::toDto)
//                .collect(Collectors.toList());

        Attachment example1 = new Attachment();
        example1.setDegree(degree);
        List<Attachment> attachmentList = attachmentRepository.findAll(Example.of(example1));

        for (Attachment attachment : attachmentList){
            Path path = root.resolve(attachment.getName());
//            File file = new File(path.toString());
//            String url = MvcUriComponentsBuilder.;
//            attachment.setPath(url);
            attachment.setFile(path);
        }


        return attachmentList.stream()
                .map(attachmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Resource load(String name) throws MalformedURLException {
        Path file = root.resolve(name);
        Resource resource = new UrlResource(file.toUri());
        return resource;
    }
}
