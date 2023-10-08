package com.hibernate.springbootCrudApi.dao;

import java.util.List;

import com.hibernate.springbootCrudApi.model.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class,id);
		if(employeeObj == null){
			throw new RuntimeException("Employee with id "+id+" is not found");
		}
		return employeeObj;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
//		if(employee.getId() !=null){
//		Employee employeeObj = currentSession.get(Employee.class, employee.getId());
//		}
		currentSession.merge(employee);
	}

	@Override
	public String delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class,id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee with id "+id+" not found");
		}
		currentSession.remove(employeeObj);
		return ("Employee of id "+id+" get deleted");
	}
}
