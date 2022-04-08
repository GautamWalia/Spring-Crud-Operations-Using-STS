package com.fresher.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fresher.demo.custom.exception.BusinessException;
import com.fresher.demo.custom.exception.ControllerException;
import com.fresher.demo.entity.Employee;
import com.fresher.demo.repository.EmployeeCrudRepo;
import com.fresher.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController
{
	//Employee emp;
	
	@Autowired
	private EmployeeServiceInterface empSerInterface;
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
	{
		try
		{
			Employee empSaved= empSerInterface.addEmployee(emp);
			return new ResponseEntity<Employee>(empSaved, HttpStatus.CREATED);
		}
		catch(BusinessException e) 
		{
			ControllerException ce= new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) 
		{
			ControllerException ce= new ControllerException("609", "Something went worng in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
		//return null;
	}
	
	@GetMapping("/all")
	public  ResponseEntity<?> getAllEmployees()
	{
		//System.out.print("getting employees");
		try
		{
			List<Employee> listOfallEmp= empSerInterface.getAllEmployees();
			return new ResponseEntity<List<Employee>> (listOfallEmp, HttpStatus.OK);
		}
		catch(BusinessException e) 
		{
			ControllerException ce= new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) 
		{
			ControllerException ce= new ControllerException("610", "Something went worng in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/emp/{empID}")
	public ResponseEntity<?> getEmpById(@PathVariable("empID") int id) 
	{
		try
		{
			Employee empReterived= empSerInterface.getEmpById(id);
			return new ResponseEntity<Employee>(empReterived, HttpStatus.OK);
		}
		catch(BusinessException e) 
		{
			ControllerException ce= new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) 
		{
			ControllerException ce= new ControllerException("611", "Something went worng in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{empID}")
	public ResponseEntity<?> delEmpById(@PathVariable("empID") int id)
	{
		
		try
		{
			 empSerInterface.delEmpById(id);
			return new ResponseEntity<>("emp Deleted", HttpStatus.OK);
		}
		catch(BusinessException e) 
		{
			ControllerException ce= new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) 
		{
			ControllerException ce= new ControllerException("612", "Something went worng in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NO_CONTENT);
		}
	} 
		
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp)
	{
		try
		{
			Employee empSaved= empSerInterface.addEmployee(emp);
			return new ResponseEntity<Employee>(empSaved, HttpStatus.CREATED);
		}
		catch(BusinessException e) 
		{
			ControllerException ce= new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) 
		{
			ControllerException ce= new ControllerException("613", "Something went worng in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
		//return null;
	}
	
}
