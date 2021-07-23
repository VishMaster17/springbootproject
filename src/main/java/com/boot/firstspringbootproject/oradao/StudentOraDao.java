package com.boot.firstspringbootproject.oradao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.firstspringbootproject.model.Student;

@Repository
public interface StudentOraDao extends JpaRepository<Student, Integer> {
	
	List<Student> findByPercentageGreaterThanEqual(Float percentage);
	
	List<Student> findByPercentageLessThan(Float percentage);
	
	List<Student> findBySchool(String schoolName);

}
