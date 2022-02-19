package org.umss.aub.web.rest.config;


import org.springframework.web.bind.annotation.*;
import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.DegreeFormDTO;
import org.umss.aub.service.config.DegreeService;

import java.util.List;

@RestController
@RequestMapping("/v1/config/degree")
public class DegreeResource {

    private final DegreeService degreeService;


    public DegreeResource(DegreeService degreeService) {
        this.degreeService = degreeService;
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
}
