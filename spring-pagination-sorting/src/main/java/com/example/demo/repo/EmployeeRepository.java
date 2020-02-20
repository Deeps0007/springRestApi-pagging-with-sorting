package com.example.demo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.EmployeeEntity;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Long>{

}
