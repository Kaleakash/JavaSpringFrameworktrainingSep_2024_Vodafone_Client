package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
// curl -X POST http://localhost:9191/employee_store -H "Content-Type:application/json" -d '{"id":101,"name":"Leena","salary":42000}'
	
	@RequestMapping(value = "employee_store",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeEmployee(@RequestBody Employee employee) {
		return employeeService.storeEmployee(employee);
	}
// curl -X GET http://localhost:9191/employee_find
	@RequestMapping(value = "employee_find",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findAll(){
		return employeeService.findAllEmployee();
	}
}
