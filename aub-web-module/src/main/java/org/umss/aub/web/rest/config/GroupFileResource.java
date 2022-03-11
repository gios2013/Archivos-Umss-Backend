package org.umss.aub.web.rest.config;

import org.springframework.web.bind.annotation.*;
import org.umss.aub.dto.config.GroupFileDTO;
import org.umss.aub.service.config.GroupFileService;

import java.util.List;

@RestController
@RequestMapping("/v1/config/group_file")
public class GroupFileResource {

    public final GroupFileService groupFileService;

    public GroupFileResource(GroupFileService groupFileService) {
        this.groupFileService = groupFileService;
    }

    @GetMapping
    public List<GroupFileDTO> getAllGroups(){
        return groupFileService.findAll();
    }

    @PostMapping
    public GroupFileDTO saveGroup(GroupFileDTO groupFileDTO){
        return groupFileService.save(groupFileDTO);
    }

    @GetMapping("/{groupUuid}")
    public GroupFileDTO findByUuid(@PathVariable String groupUuid){
        return groupFileService.findByUuid(groupUuid);
    }
}
