package com.hibernate.springbootCrudApi.controller;

import java.util.List;

import com.hibernate.springbootCrudApi.model.Employee;
import com.hibernate.springbootCrudApi.service.EmployeeService;
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

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> get() {
		return employeeService.get();
	}

	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeObj){
		employeeService.save(employeeObj);
		return employeeObj;
	}
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeObj){
		employeeService.save(employeeObj);
		return employeeObj;
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id){
		Employee employeeObj =  employeeService.get(id);
		return new ResponseEntity<Employee>(employeeObj,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id){
		return employeeService.delete(id);
	}
}
