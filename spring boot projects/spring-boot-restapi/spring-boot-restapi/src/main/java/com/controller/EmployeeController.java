
package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// http://localhost:9191/post_test
	
	@RequestMapping(value = "post_test",method = RequestMethod.POST)
	public String postMethodTest() {
		return "Post method test";
	}
	// http://localhost:9191/store_employee			, method : post 
	// data : {"id":100,"name":"Steven","salary":45000}
	
	@RequestMapping(value = "store_employee",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeEmployee(@RequestBody Employee employee) {  // @RequestBody 
		System.out.println(employee);					// annotation is use to extract json data from request body
		return "Post method test "+employee.getName();
	}
	
	@RequestMapping(value = "emp_json",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
	public Employee convertJsonToXML(@RequestBody Employee employee) {  // @RequestBody 
		employee.setSalary(employee.getSalary()+6000);
		return employee;
	}
	
	// http://localhost:9191/emp_delete/100
	
	@RequestMapping(value = "emp_delete/{id}",method = RequestMethod.DELETE)
	public String deleteEmployeeInfo(@PathVariable("id") int id) {
		return "Employee record delete using id as "+id;
	}
	
	
}
