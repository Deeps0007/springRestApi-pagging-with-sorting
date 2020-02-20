package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.RecordNotFoundException;

public interface EmployeeService {

	List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);

	EmployeeEntity createOrUpdateEmployee(EmployeeEntity employee);

	void deleteEmployeById(Long id) throws RecordNotFoundException;

	
}
