package com.fresher.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fresher.demo.custom.exception.BusinessException;
import com.fresher.demo.entity.Employee;
import com.fresher.demo.repository.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface 
{
	@Autowired
	EmployeeCrudRepo repo;
	
	@Override
	public Employee addEmployee(Employee employee) 
	{
		
			Employee savedEmployee= repo.save(employee);
			return savedEmployee;
		
	}
	
	@Override
	public List<Employee> getAllEmployees()
	{
		List<Employee> empList= repo.findAll();
		return empList;
	}
	
	@Override
	public Employee getEmpById(int id) 
	{	
		Employee emp= repo.findById(id).get();
		return emp;
		
	}
	
	@Override
	public void delEmpById(int id) 
	{
		repo.deleteById(id);
	}
	
	@Override
	public void updateEmployee(Employee employee) 
	{
			updateEmployee(employee);
		
	}
	
}
