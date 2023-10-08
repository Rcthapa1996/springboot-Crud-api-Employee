package com.hibernate.springbootCrudApi.dao;

import java.util.List;

import com.hibernate.springbootCrudApi.model.Employee;

public interface EmployeeDAO {

	List<Employee> get();

	Employee get(int id);

	void save(Employee employee);

	String delete(int id);
}
