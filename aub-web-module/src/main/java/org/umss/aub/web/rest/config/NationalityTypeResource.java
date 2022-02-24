package org.umss.aub.web.rest.config;


import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/delete/{id}")
    public void deleteLogicalNationality(@PathVariable Integer id){
        nationalityTypeService.logicalDelete(id);
    }

    @PostMapping("/enable/{id}")
    public void enableLogicalNationality(@PathVariable Integer id){
        nationalityTypeService.logicalEnable(id);
    }
}
