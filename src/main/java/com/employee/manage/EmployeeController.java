package com.employee.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("list-emp");
        List<Employee> employeeList = employeeService.getAll();
        mav.addObject("employees",employeeList);
        return mav;
    }

//post
    @GetMapping("/addEmpForm")
    public ModelAndView addEmployeeForm(){
        ModelAndView mav = new ModelAndView("add-emp-form");
        Employee employee=new Employee();
        mav.addObject("employee",employee);
        return mav;
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/list";
    }

//put
    @GetMapping("/updateEmpForm")
    public ModelAndView updateEmployeeForm(@RequestParam Integer id){
        ModelAndView mav = new ModelAndView("add-emp-form");
        Employee employee=employeeService.getEmployeeById(id);
        mav.addObject("employee",employee);
        return mav;
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/list";
    }

}
