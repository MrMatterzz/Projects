package com.dashboard.domain;

import java.io.Serializable;

public class Course implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	
	 private String id;
	
	 private String title;
	 private String professor;
	 private String description;
	 

	public Course() {
		super();
	}

	public Course(String title, String professor, String description) {
		super();
		this.title = title;
		this.professor = professor;
		this.description = description;
	}
	
	public Course(String id, String title, String professor, String description) {
		super();
		this.id = id;
		this.title = title;
		this.professor = professor;
		this.description = description;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "(id=" + id + ") " + title + ", " + professor + ", " + description;
	}
	

	
	

	
}
