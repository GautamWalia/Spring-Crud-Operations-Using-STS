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
		if(employee.getName().isEmpty() || employee.getName().length() ==0) 
		{
			throw new BusinessException("601", "Name cannot be empty");
		}
		try 
		{
			Employee savedEmployee= repo.save(employee);
			return savedEmployee;
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("602", "Emloyee cannot be null"+ e.getMessage());
		}
		catch(Exception e) 
		{
			throw new BusinessException("603", "Something went wrong in Service Layer"+ e.getMessage());
		}
	}
	
	@Override
	public List<Employee> getAllEmployees()
	{
		List<Employee> empList= repo.findAll();
		if(empList.isEmpty())
			throw new BusinessException("604", "Nothing exists in database");
 		return empList;
	}
	
	@Override
	public Employee getEmpById(int id) 
	{	try 
		{
		Employee emp= repo.findById(id).get();
		if(emp.equals(null))
			throw new BusinessException("605", "employee id cannot be null");
		return emp;
		}
	
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("606", "this employee not exist in database");
		}
		
	}
	
	@Override
	public void delEmpById(int id) 
	{
		try
		{
			repo.deleteById(id);
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("607", "Employee id cannot be null"+ e.getMessage());
		}
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("608", "this employee not exist in database");
		}
	}
	
	@Override
	public void updateEmployee(Employee employee) 
	{
		try
		{
			updateEmployee(employee);
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("614", "Employee id cannot be null"+ e.getMessage());
		}
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("615", "this employee not exist in database");
		}
	}
	
}
