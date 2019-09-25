package com.cmm.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmm.employee.dao.EmployeeDAO;
import com.cmm.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	 private EmployeeDAO employeeDAO;
	 
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeeDAO.saveEmployee(theEmployee);
    }
	@Transactional
    public List<Employee> getAllEmployees(){
        return employeeDAO.getAllEmployees();
    }
	@Transactional
	public Employee getEmployee(int employee_id) {
        return employeeDAO.getEmployee(employee_id);
    }
	
//	@Transactional
//	public void updateEmployee(Employee theEmployee) {
//        // TODO Auto-generated method stub
//        employeeDAO.updateEmployee(theEmployee);
//    }
	@Transactional
	public void deleteEmployee(int id) {
		 employeeDAO.deleteEmployee(id);
	}
//	@Transactional
//	public Object findEnployeeName(String employee_name) {
//		return employeeDAO.getEmployeeName(employee_name);
//	}
	@Transactional
	public List<Employee> getEmployeeName(String employee_name, String gender){
		return employeeDAO.getEmployeeNameForSearch(employee_name,gender);
	}
	@Transactional
	public boolean checkLogin(@RequestParam("employee_id")String employee_id, @RequestParam("password")String password) {
		 return employeeDAO.checkLogin(employee_id, password);
	}
	
	
}
