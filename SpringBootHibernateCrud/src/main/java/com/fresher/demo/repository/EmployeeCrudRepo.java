package com.fresher.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fresher.demo.entity.Employee;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee, Integer>
{

}
