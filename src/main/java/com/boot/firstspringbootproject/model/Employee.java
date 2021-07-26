package com.boot.firstspringbootproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "emp", schema = "vishnu")
public class Employee {

	private String ename;
	@Id
	private Integer empno;
//	private Integer mgr;
	private String job;
	private Double sal;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "mgr")
	@JsonIgnore
	private Employee manager;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", empno=" + empno + ", job=" + job + ", sal=" + sal + "]";
	}

}
