package com.capgemini.springboot.service;

import java.util.List;

import com.capgemini.springboot.dto.EmployeeBean;

public interface EmployeeService {
	
	public EmployeeBean auth(String email, String password);
	public boolean register(EmployeeBean bean);
	public List<EmployeeBean>  getEmployee(String key);
	public boolean changePassword(int id, String password);
	public boolean deleteEmp(int id);
}
