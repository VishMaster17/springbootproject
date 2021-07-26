package com.boot.firstspringbootproject.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.firstspringbootproject.model.Employee;
import com.boot.firstspringbootproject.model.Student;
import com.boot.firstspringbootproject.oradao.EmpOraDao;
import com.boot.firstspringbootproject.oradao.StudentOraDao;

@RestController
public class DemoRestController {

	@Autowired
	StudentOraDao studentOraDao;

	@Autowired
	EmpOraDao empOraDao;

	@GetMapping(path = "/students")
	public List<Student> getAllStudents() {
		return studentOraDao.findAll();
	}

	@GetMapping(path = "/students/pageable")
	public List<Student> getAllStudentsPageable(@RequestParam("page") Optional<Integer> page,
			@RequestParam("pageSize") Optional<Integer> pageSize, @RequestParam("sortBy") Optional<String> sortBy) {
		return studentOraDao
				.findAll(PageRequest.of(page.orElse(0), pageSize.orElse(5), Sort.by(sortBy.orElse("regNo")))).toList();
	}

	@GetMapping(path = "/students/{regNo}")
	public Student getStudentFromRegNo(@PathVariable Integer regNo) {
		Optional<Student> student = studentOraDao.findById(regNo);
		if (student.isPresent()) {
			return student.get();
		} else {
			return null;
		}
	}

	@PostMapping(path = "/students", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addStudent(@RequestBody Student student) {
//		if (studentOraDao.findById(student.getRegNo()).isPresent()) {
//			return "Student already present";
		studentOraDao.save(student);
		return "Added student successfully";

	}

	@PutMapping(path = "/students/{regNo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateStudent(@RequestBody Student student) {
		studentOraDao.save(student);
		return "Updated student data successfully";
	}

	@DeleteMapping(path = "/students/{regNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteStudent(@PathVariable Integer regNo) {
		studentOraDao.deleteById(regNo);
		return "Deleted student data successfully";
	}

	@GetMapping(path = "/students/result")
	public List<Student> getPassedStudentsData(@RequestParam("pass") boolean pass) {
		if (pass) {
			return studentOraDao.findByPercentageGreaterThanEqual(40F);
		} else {
			return studentOraDao.findByPercentageLessThan(40F);
		}

	}

	@GetMapping(path = "/students/sort/name")
	public List<Student> sortByName() {
		return studentOraDao.findAll().stream().sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
	}

	@GetMapping(path = "/students/sort/percentage")
	public List<Student> sortByPercent() {
		return studentOraDao.findAll().stream().sorted(Comparator.comparing(Student::getPercentage))
				.collect(Collectors.toList());
	}

	@GetMapping(path = "/students/school/{schoolName}")
	public List<Student> getBySchool(@PathVariable String schoolName) {
		return studentOraDao.findBySchool(schoolName);
	}

	@GetMapping(path = "/fetchEmpWithMoreSal", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> fetchEmpWithMoreSal() {
		List<Employee> empList = empOraDao.findAll();
		return empList.stream().filter(e -> e.getSal() > e.getManager().getSal())
		.collect(Collectors.toList());
	}

}
