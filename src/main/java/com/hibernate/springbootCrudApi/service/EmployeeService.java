package com.hibernate.springbootCrudApi.service;

import java.util.List;

import com.hibernate.springbootCrudApi.model.Employee;

public interface EmployeeService {
	List<Employee> get();

	Employee get(int id);

	void save(Employee employee);

	String delete(int id);
}
