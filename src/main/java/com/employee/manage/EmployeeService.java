package com.employee.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll(){
        return (List<Employee>) repository.findAll();
    }

    public Employee getEmployeeById(Integer id){
        return repository.findById(id).get();
    }

    public void addEmployee(Employee employee){
        repository.save(employee);
    }

    public void updateEmployee(Integer id,Employee employee){
        Employee savedEmp =  repository.findById(id).get();
        savedEmp.setName(employee.getName());
        savedEmp.setDepartment(employee.getDepartment());
        savedEmp.setEmail(employee.getEmail());
        repository.save(savedEmp);
    }

    public void deleteEmployee(Integer id){
        repository.deleteById(id);
    }

}
