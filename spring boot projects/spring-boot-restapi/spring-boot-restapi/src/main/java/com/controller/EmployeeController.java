
package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

@RestController
public class EmployeeController {
	// http://localhost:9191/employee_json
	@RequestMapping(value = "employee_json",
			method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeJSON() {
		Employee emp1 = new Employee(100, "Steven", 45000);
		return emp1;
	}
	// http://localhost:9191/employee_xml
	@RequestMapping(value = "employee_xml",
			method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE)
	public Employee getEmployeeXML() {
		Employee emp1 = new Employee(100, "Steven", 45000);
		return emp1;
	}
	// http://localhost:9191/employees_json
	@RequestMapping(value = "employees_json",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeesJson() {
		Employee emp1 = new Employee(100, "Steven", 45000);
		Employee emp2 = new Employee(101, "Ravi", 48000);
		Employee emp3 = new Employee(102, "Leena", 50000);
		List<Employee> listOfEmp = new ArrayList<Employee>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		return listOfEmp;
	}
	// // http://localhost:9191/employees_xml
	// not working with xml list of employee 
	@RequestMapping(value = "employees_xml",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_XML_VALUE)
	public List<Employee> getEmployeesXmlEmployees() {
		Employee emp1 = new Employee(100, "Steven", 45000);
		Employee emp2 = new Employee(101, "Ravi", 48000);
		Employee emp3 = new Employee(102, "Leena", 50000);
		List<Employee> listOfEmp = new ArrayList<Employee>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		return listOfEmp;
	}
}
