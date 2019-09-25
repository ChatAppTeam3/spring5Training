package com.cmm.employee.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cmm.employee.entity.Employee;
import com.cmm.employee.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	 public String userForm(Model model) {	
	Employee employee=new Employee();
		model.addAttribute("employee", employee);
		 
	      return "loginform";
	   }
	@GetMapping("/employeeInsert")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "EMP0001";
	}

	@PostMapping(value = "/saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		Date date = new java.sql.Date(new java.util.Date().getTime());

//    	if (theEmployee.getId() == 0) {
		for (int i = 0; i < theEmployee.getId() + 1; i++) {
			String emp;
			if (theEmployee.getId() < 10) {
				emp = "EMP000" + (theEmployee.getId());
				theEmployee.setEmployee_id(emp);
			} else if (theEmployee.getId() >= 10 && theEmployee.getId() < 100) {
				emp = "EMP00" + (theEmployee.getId());
				theEmployee.setEmployee_id(emp);
			} else if (theEmployee.getId() >= 100 && theEmployee.getId() < 1000) {
				emp = "EMP0" + (theEmployee.getId());
				theEmployee.setEmployee_id(emp);
			} else {
				emp = "EMP" + (theEmployee.getId());
				theEmployee.setEmployee_id(emp);
			}
			employeeService.saveEmployee(theEmployee);
		}
		
//    	}
//    	else
//    	{
//   		employeeService.updateEmployee(theEmployee);
//   		return new ModelAndView("redirect:/listEmployee");
//        }
		return new ModelAndView("redirect:/listEmployee");
	}

//	For List from index.jsp
	@RequestMapping(value = "/listEmployee")
	public ModelAndView listEmployee(HttpServletRequest request, ModelAndView model) throws IOException {
		List<Employee> theEmployees = employeeService.getAllEmployees();
		model.addObject("listEmployee", theEmployees);
		model.setViewName("EMP0002");
		return model;
	}

//   Search form for EMP0002
	@RequestMapping(value = "/employeeSearch", method = RequestMethod.POST)
	public ModelAndView searchEmployee(ModelAndView model, HttpServletRequest request,
			@RequestParam("employee_name") String employee_name,@RequestParam("gender") String gender) throws IOException {
		List<Employee> theEmployee = employeeService.getEmployeeName(employee_name,gender);
		model.addObject("listEmployee", theEmployee);
		model.setViewName("EMP0002");
		return model;
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int employee_id = Integer.parseInt(request.getParameter("id"));
		Employee theEmployee = employeeService.getEmployee(employee_id);
		ModelAndView model = new ModelAndView("EMP0001");
		model.addObject("employee", theEmployee);
		return model;
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		for (String id : request.getParameterValues("id"))
			// int employee_id = Integer.parseInt(request.getParameter("id"));
			employeeService.deleteEmployee(Integer.parseInt(id));
		return new ModelAndView("redirect:/listEmployee");
	}

}
