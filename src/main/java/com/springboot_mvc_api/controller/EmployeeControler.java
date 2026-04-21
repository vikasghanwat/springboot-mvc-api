package com.springboot_mvc_api.controller;

import com.springboot_mvc_api.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeControler {

    @GetMapping("/server")
    public String testServer() {
        return "Server up....";
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return new EmployeeDTO(id, "Virat", "virat@rcb.com", 37, LocalDate.of(2008, 8, 18), true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return "Hi age " + age + " " + sortBy;
    }


    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(100L);
        return inputEmployee;
    }


}
