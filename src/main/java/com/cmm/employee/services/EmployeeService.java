package com.cmm.employee.services;

import java.util.List;

import com.cmm.employee.entity.Employee;

public interface EmployeeService {

	public void saveEmployee(Employee theEmployee);

	public List<Employee> getAllEmployees();

	public Employee getEmployee(int employee_id);

//	public void updateEmployee(Employee theEmployee);

	public void deleteEmployee(int id);

//	public Object findEnployeeName(String employee_name);

	public List<Employee> getEmployeeName(String employee_name, String gender);
	 public boolean checkLogin(String employee_id, String password);

}
