package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public EmployeeEntity info()
	{
		return new EmployeeEntity();
	}
	
	@GetMapping("/allemployee")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees(
			@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "10")Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) throws RecordNotFoundException     
	{
		List<EmployeeEntity>employeeList= employeeService.getAllEmployees(pageNo, pageSize,sortBy);
		return new ResponseEntity<List<EmployeeEntity>>(employeeList, new HttpHeaders(), HttpStatus.OK);
		
		
	}
	
	@PostMapping("/saveorupdate")
	public ResponseEntity<EmployeeEntity> createOrUpadateEmployee(@RequestBody EmployeeEntity employee)
	{
		
		EmployeeEntity updatedEmployee=employeeService.createOrUpdateEmployee(employee);
		
		return new ResponseEntity<EmployeeEntity>(updatedEmployee,new HttpHeaders() , HttpStatus.OK);
		
	}
	 
	@DeleteMapping("{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException       
	{
		employeeService.deleteEmployeById(id);
		return HttpStatus.FORBIDDEN;
	}
	
	
}
