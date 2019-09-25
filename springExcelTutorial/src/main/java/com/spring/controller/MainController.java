package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Student;
import com.spring.view.ExcelReportView;

@Controller
@RequestMapping("/report")
public class MainController {
	 @RequestMapping(method=RequestMethod.GET)
     public ModelAndView getExcel(){
            List<Student> studentList1234 = new ArrayList<Student>(); 
            studentList1234.add(new Student("S01", "Sri", "12344"));
            studentList1234.add(new Student("S02", "Dharan", "658"));
            return new ModelAndView(new ExcelReportView(), "studentList", studentList1234);
     } 
}
