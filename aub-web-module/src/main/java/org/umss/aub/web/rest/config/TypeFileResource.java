package org.umss.aub.web.rest.config;


import org.springframework.web.bind.annotation.*;
import org.umss.aub.dto.config.DegreeDTO;
import org.umss.aub.dto.config.TypeFileDTO;
import org.umss.aub.service.config.TypeFileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/config/type")
public class TypeFileResource {

    public final TypeFileService typeFileService;

    public TypeFileResource(TypeFileService typeFileService) {
        this.typeFileService = typeFileService;
    }

    @GetMapping
    public List<TypeFileDTO> getTypes(){
        return typeFileService.findAll();
    }

    @PostMapping
    public TypeFileDTO saveType(TypeFileDTO typeFileDTO){
        return typeFileService.save(typeFileDTO);
    }

    @GetMapping("/byId/{id}")
    public Optional<TypeFileDTO> getOne(@PathVariable Integer id){
        return typeFileService.findById(id);
    }

    @GetMapping("/{typeUuid}")
    public TypeFileDTO getByUuid(@PathVariable String typeUuid){
        return typeFileService.findByUuid(typeUuid);
    }

    @GetMapping("/{typeUuid}/degree")
    public List<DegreeDTO> getAllDegrees(@PathVariable String typeUuid){
        return typeFileService.getAllByUuid(typeUuid);
    }

    @PostMapping("/{typeUuid}")
    public TypeFileDTO updateType(@RequestBody TypeFileDTO typeFileDTO, @PathVariable String typeUuid){
        return typeFileService.editByUuid(typeUuid, typeFileDTO);
    }
}
