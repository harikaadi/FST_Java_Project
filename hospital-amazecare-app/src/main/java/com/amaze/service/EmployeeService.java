package com.amaze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amaze.model.Employee;
import com.amaze.model.UserInfo;
import com.amaze.repo.EmployeeRepositary;
import com.amaze.repo.UserRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Autowired
	private UserRepository userrepositary;
	
	@Autowired
	private EmployeeRepositary employeerepository;

	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		//detach user info from employee
		UserInfo userinfo=employee.getUser();
		
		userinfo.setRole("ROLE_EMPLOYEE");
		
		userinfo.setPassword(passwordencoder.encode(userinfo.getPassword()));
		
		userinfo = userrepositary.save(userinfo);
		
		//attaching user to employee
		employee.setUser(userinfo);
		
		return employeerepository.save(employee);
		
		
	}

}
