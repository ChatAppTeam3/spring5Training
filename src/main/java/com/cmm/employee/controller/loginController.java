package com.cmm.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cmm.employee.entity.Employee;
import com.cmm.employee.services.EmployeeService;

@Controller
public class loginController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/login")
	 public String login(@ModelAttribute("employee") @Valid Employee employee, BindingResult result,
			   Model model) {
		

      boolean userExists =employeeService.checkLogin(employee.getEmployee_id(),
	    		  employee.getPassword());
			if(userExists){
				return "EMP0001";
			}else{
		
			return "dashboard";
		}
			
	      }
	}

