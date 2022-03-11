package org.umss.aub.web.rest.config;


import org.springframework.web.bind.annotation.*;
import org.umss.aub.dto.config.StudentDTO;
import org.umss.aub.service.config.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/config/students")
public class StudentResource {

    private final StudentService studentService;


    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @PostMapping
    public StudentDTO saveStudent(StudentDTO studentDTO){
        return studentService.save(studentDTO);
    }

    @GetMapping("/{studentUuid}")
    public StudentDTO getOneByUuid(@PathVariable String studentUuid){

        return studentService.findByUuid(studentUuid);
    }

    @GetMapping("/id/{id}")
    public Optional<StudentDTO> getById(@PathVariable Integer id){
        return studentService.findById(id);
    }

    @GetMapping("/ci/{ci}")
    public StudentDTO getByCi(@PathVariable Integer ci){
        return studentService.findByCi(ci);
    }

}
