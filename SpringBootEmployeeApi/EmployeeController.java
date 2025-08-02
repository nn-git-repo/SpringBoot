package com.company.employee_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	 @GetMapping("/employee")
	    public Map<String, Object> getEmployeeInfo() {
	        Map<String, Object> employee = new HashMap<>();
	        employee.put("id", 101);
	        employee.put("name", "Namratha N");
	        employee.put("department", "Engineering");
	        return employee;
	    }
}
