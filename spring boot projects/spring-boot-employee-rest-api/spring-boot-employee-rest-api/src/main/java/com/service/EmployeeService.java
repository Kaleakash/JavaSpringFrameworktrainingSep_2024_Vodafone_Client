package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public String storeEmployee(Employee employee) {
		//employeeRepository.save(employee);
		if(employeeRepository.existsById(employee.getId())) {
			return "Employee id must be unique";
		}else {
			employeeRepository.save(employee);
			return "Employee stored";
		}
	}
}


