package com.springboot_mvc_api.controller;

import com.springboot_mvc_api.entity.EmployeeEntity;
import com.springboot_mvc_api.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeControler {

    private final EmployeeRepository employeeRepository;

    public EmployeeControler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

/*    @GetMapping("/server")
    public String testServer() {
        return "Server up....";
    }*/

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
    }


    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }

}
