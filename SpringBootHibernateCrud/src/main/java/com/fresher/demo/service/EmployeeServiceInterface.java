package com.fresher.demo.service;

import java.util.List;

import com.fresher.demo.entity.Employee;

public interface EmployeeServiceInterface {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmpById(int id);

	void delEmpById(int id);

	void updateEmployee(Employee employee);

	

}
