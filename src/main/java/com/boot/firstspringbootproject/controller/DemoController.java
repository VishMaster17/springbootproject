package com.boot.firstspringbootproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.firstspringbootproject.model.Employee;
import com.boot.firstspringbootproject.oradao.EmpOraDao;
import com.boot.firstspringbootproject.postdao.EmpPostDao;

@Controller
public class DemoController {

	@Autowired
	EmpOraDao oraDao;

	@Autowired
	EmpPostDao postDao;

	@RequestMapping("/")
	public String getHealth() {
		return "welcome.jsp";
	}

	@RequestMapping("/findById")
	@ResponseBody
	public String findById(Integer id) {
		id = 7499;
		Optional<Employee> employee = oraDao.findById(id);
		if (employee.isPresent()) {
			return employee.get().toString();
		} else {
			return "Employee not found";
		}
	}

	@RequestMapping("/addEmp")
	@ResponseBody
	public String addEmp() {
		Employee e = new Employee();
		e.setEmpno(2);
		e.setEname("Vish");
		e.setJob("Manager");
		oraDao.save(e);
		postDao.save(e);
		return "Added employee successfully";
	}

}
