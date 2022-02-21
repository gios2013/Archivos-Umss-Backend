package org.umss.aub.web.rest.config;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.umss.aub.dto.config.NationalityTypeDTO;
import org.umss.aub.dto.config.NationalityTypeFormDTO;
import org.umss.aub.service.config.NationalityTypeService;

import java.util.List;

@RestController
@RequestMapping("/v1/config/nationality_type")
public class NationalityTypeResource {

    private final NationalityTypeService nationalityTypeService;


    public NationalityTypeResource(NationalityTypeService nationalityTypeService) {
        this.nationalityTypeService = nationalityTypeService;
    }

    @GetMapping
    public List<NationalityTypeDTO> getAllNationalities(){
        return nationalityTypeService.findAll();
    }

    @PostMapping
    public NationalityTypeDTO saveTypeNationality(NationalityTypeFormDTO nationalityTypeFormDTO){
        return nationalityTypeService.saveWithFiles(nationalityTypeFormDTO);
    }
}
