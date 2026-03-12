package com.ets.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ets.model.SelectEmployee;
import com.ets.service.SelectEmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class SelectEmployeeController {

    private final SelectEmployeeService selectEmployeeService;

    public SelectEmployeeController(SelectEmployeeService selectEmployeeService) {
        this.selectEmployeeService = selectEmployeeService;
    }

    @GetMapping
    public List<SelectEmployee> getAllEmployees() {
        return selectEmployeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public SelectEmployee getEmployeeById(@PathVariable Long id) {
        return selectEmployeeService.getEmployeeById(id);
    }

    @PostMapping
    public SelectEmployee createEmployee(@RequestBody SelectEmployee employee) {
        return selectEmployeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        selectEmployeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
