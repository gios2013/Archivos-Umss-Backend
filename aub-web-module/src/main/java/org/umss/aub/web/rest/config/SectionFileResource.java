package org.umss.aub.web.rest.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.umss.aub.dto.config.SectionFileDTO;
import org.umss.aub.service.config.SectionFileService;

import java.util.List;

@RestController
@RequestMapping("/v1/config/sections")
public class SectionFileResource {

    private final Logger log = LoggerFactory.getLogger(SectionFileResource.class);

    private final SectionFileService sectionFileService;

    public SectionFileResource(SectionFileService sectionFileService) {
        this.sectionFileService = sectionFileService;
    }

    @GetMapping
    public List<SectionFileDTO> getSections(@RequestParam(name = "active",defaultValue = "true") boolean active) {
        if (active){
            return sectionFileService.findAllActive();
        }else {
            return sectionFileService.findAll();
        }
    }
}
