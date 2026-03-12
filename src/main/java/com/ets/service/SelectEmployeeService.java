package com.ets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ets.model.SelectEmployee;
import com.ets.repository.SelectEmployeeRepository;

@Service
public class SelectEmployeeService {

    private final SelectEmployeeRepository selectEmployeeRepository;

    public SelectEmployeeService(SelectEmployeeRepository selectEmployeeRepository) {
        this.selectEmployeeRepository = selectEmployeeRepository;
    }

    public List<SelectEmployee> getAllEmployees() {
        return selectEmployeeRepository.findAll();
    }

    public SelectEmployee saveEmployee(SelectEmployee employee) {
        return selectEmployeeRepository.save(employee);
    }

    public SelectEmployee getEmployeeById(Long id) {
        return selectEmployeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public void deleteEmployee(Long id) {
        selectEmployeeRepository.deleteById(id);
    }
}
