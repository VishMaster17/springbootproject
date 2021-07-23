package com.boot.firstspringbootproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "vishnu")
public class Student {

	@Id
	@Column(name = "REG_NO")
	private Integer regNo;
	private String name;
	private Float percentage;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "standard")
	private School school;

	public Integer getRegNo() {
		return regNo;
	}

	public void setRegNo(Integer regNo) {
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [regNo=" + regNo + ", name=" + name + ", percentage=" + percentage
				+ ", school=" + school + "]";
	}

}
