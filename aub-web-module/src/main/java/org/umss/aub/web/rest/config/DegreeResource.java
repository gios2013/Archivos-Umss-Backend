package org.umss.aub.web.rest.config;


import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.umss.aub.dto.config.AttachmentDTO;
import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.DegreeFormDTO;
import org.umss.aub.dto.config.StudentRecordDTO;
import org.umss.aub.service.config.DegreeAttachmentService;
import org.umss.aub.service.config.DegreeService;
import org.umss.aub.service.config.DegreeStudentRecordService;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequestMapping("/v1/config/degree")
public class DegreeResource {

    private final DegreeService degreeService;

    private final DegreeAttachmentService degreeAttachmentService;

    private final DegreeStudentRecordService degreeStudentRecordService;


    public DegreeResource(DegreeService degreeService, DegreeAttachmentService degreeAttachmentService, DegreeStudentRecordService degreeStudentRecordService) {
        this.degreeService = degreeService;
        this.degreeAttachmentService = degreeAttachmentService;
        this.degreeStudentRecordService = degreeStudentRecordService;
    }

    @GetMapping
    public List<DegreeDTO> getAllDegrees(){
        return degreeService.findAll();
    }

    @GetMapping("/bachiller")
    public List<DegreeDTO> getAllByBachiller(){
        return degreeService.findAllByBachiller();
    }

    @PostMapping("/unclassified")
    public DegreeDTO saveDegreeFile(DegreeFormDTO degreeFormDTO){
        return degreeService.saveWithFiles(degreeFormDTO);
    }

    @GetMapping("/{degreeUuid}")
    public DegreeDTO getDegreeByUuid(@PathVariable String degreeUuid){
        DegreeDTO degreeDTO = degreeService.getByUuid(degreeUuid);
        List<AttachmentDTO> degrees = degreeDTO.getAttachmentDTOS();
        List<StudentRecordDTO> records = degreeDTO.getStudentRecordDTOS();
        for (AttachmentDTO attachmentDTO:degrees){
            String url = MvcUriComponentsBuilder.
                    fromMethodName(DegreeResource.class,
                            "getfile",
                            attachmentDTO.getFile().getFileName().toString())
                    .build().toString();
            attachmentDTO.setPath(url);
        }
        for (StudentRecordDTO recordDTO:records){
            String url = MvcUriComponentsBuilder.
                    fromMethodName(DegreeResource.class,
                            "getrecord",
                            recordDTO.getFile().getFileName().toString())
                    .build().toString();
            recordDTO.setPath(url);
        }
        return degreeDTO;
    }

    @GetMapping("/attachments/{filename:.+}")
    public ResponseEntity<Resource> getfile(@PathVariable("filename") String filename) throws MalformedURLException {
        Resource resource = degreeAttachmentService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/records/{filename:.+}")
    public ResponseEntity<Resource> getrecord(@PathVariable("filename") String filename) throws MalformedURLException {
        Resource resource = degreeStudentRecordService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/edit/{degreUuid}")
    public DegreeDTO editDegree(DegreeDTO degreeDTO, @PathVariable String degreUuid){
        return degreeService.editById(degreUuid, degreeDTO);
    }
}
