package com.boot.firstspringbootproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "school", schema = "vishnu")
public class School {

	@Id
	private Integer standard;
	
	@Column(name = "CLASS_TEACHER")
	private String classTeacher;
	
	@OneToMany(mappedBy = "school")
	private List<Student> student;

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

}
