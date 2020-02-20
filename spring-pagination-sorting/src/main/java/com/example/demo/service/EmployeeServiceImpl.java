package com.example.demo.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeRepository;
	
	@Override
	public List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {

		org.springframework.data.domain.Pageable pagging=PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Page<EmployeeEntity> pageResult=employeRepository.findAll(pagging);
		        
		if(pageResult.hasContent())
			return pageResult.getContent();
		else
		return new ArrayList<EmployeeEntity>();
	}

	@Override
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity employee) {

		
		Optional<EmployeeEntity>newEmployee=employeRepository.findById(employee.getId());
		if(newEmployee.isPresent())
		{
              EmployeeEntity oldEmployee=newEmployee.get();
              oldEmployee.setEmail(employee.getEmail());
              oldEmployee.setFirst_name(employee.getFirst_name());
              oldEmployee.setLast_name(employee.getLast_name());
              oldEmployee.setMobile_number(employee.getMobile_number());
              
              return employeRepository.save(oldEmployee);
		}
		else
		return employeRepository.save(employee);
	}

	public void deleteEmployeById(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = employeRepository.findById(id);
         
        if(employee.isPresent())
        {
        	employeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No such Employee found for given id");
        }
    }
}
