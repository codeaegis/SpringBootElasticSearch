package com.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;

@RestController
public class EmployeeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/getAllEmployeeInfo")
	public List<Employee> getEmployees() {
		logger.info("Request received in getAllEmployeeInfo");
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee(1, "Anshuman", "Jaiswal", "anshuman.j@gmail.com"));
		employeesList.add(new Employee(1, "Mach", "Alpha", "mach.alpha@gmail.com"));
		employeesList.add(new Employee(1, "Mississippi", "One", "mississippi.one@gmail.com"));
		logger.info("Response for getAllEmployeeInfo -> " + employeesList);
		return employeesList;
	}

}
