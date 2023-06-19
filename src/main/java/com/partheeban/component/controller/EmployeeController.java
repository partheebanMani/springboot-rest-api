package com.partheeban.component.controller;


import com.partheeban.component.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/{id}")
    public Employee getEmployee(){
        return null;
    }
}
