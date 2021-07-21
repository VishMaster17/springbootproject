package com.boot.firstspringbootproject.postdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.firstspringbootproject.model.Employee;

@Repository
public interface EmpPostDao extends JpaRepository<Employee, Integer> {

}
