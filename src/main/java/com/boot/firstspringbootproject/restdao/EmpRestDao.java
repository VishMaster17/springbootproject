package com.boot.firstspringbootproject.restdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.boot.firstspringbootproject.model.Employee;

@RepositoryRestResource(collectionResourceRel = "restEmp")
public interface EmpRestDao extends JpaRepository<Employee, Integer> {

}
