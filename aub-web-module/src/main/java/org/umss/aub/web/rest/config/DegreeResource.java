package org.umss.aub.web.rest.config;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/unclassified")
    public DegreeDTO saveDegreeFile(DegreeFormDTO degreeFormDTO){
        return degreeService.saveWithFiles(degreeFormDTO);
    }
}
