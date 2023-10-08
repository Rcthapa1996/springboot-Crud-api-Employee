package com.hibernate.springbootCrudApi.service;

import java.util.List;

import com.hibernate.springbootCrudApi.dao.EmployeeDAO;
import com.hibernate.springbootCrudApi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Transactional
	@Override
	public List<Employee> get() {
		List<Employee> result = employeeDAO.get();
		return result;
	}

	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		 employeeDAO.save(employee);
	}

	@Transactional
	@Override
	public String delete(int id) {
		return employeeDAO.delete(id);
	}
}
