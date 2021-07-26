package com.boot.firstspringbootproject.oradao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.firstspringbootproject.model.Employee;

@Repository
public interface EmpOraDao extends JpaRepository<Employee, Integer> {
	

}
