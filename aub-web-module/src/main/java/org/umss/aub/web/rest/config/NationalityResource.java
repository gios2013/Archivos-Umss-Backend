package org.umss.aub.web.rest.config;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.umss.aub.dto.config.NationalityDTO;
import org.umss.aub.service.config.NationalityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/config/nationality")
public class NationalityResource {

    public final NationalityService nationalityService;


    public NationalityResource(NationalityService nationalityService) {
        this.nationalityService = nationalityService;
    }

    @GetMapping
    public Page<NationalityDTO> findAllNationalities(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size,
                                                     @RequestParam(defaultValue = "name") String order,
                                                     @RequestParam(defaultValue = "true") boolean asc) {

        return nationalityService.findAll(PageRequest.of(page, size, Sort.by(order)));
    }

    @GetMapping("/{id}")
    public Optional<NationalityDTO> findNationalityById(@PathVariable Integer id){
        return nationalityService.findById(id);
    }

    @PostMapping
    public NationalityDTO saveNationality(NationalityDTO nationalityDTO){
        return nationalityService.save(nationalityDTO);
    }

    @PostMapping("/{id}")
    public NationalityDTO editNationality(@PathVariable Integer id,@RequestBody NationalityDTO nationalityDTO){
        return nationalityService.editById(id, nationalityDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteNationality(@PathVariable Integer id){
        nationalityService.logicalDelete(id);
    }
}
