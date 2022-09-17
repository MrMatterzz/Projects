package com.dashboard.domain;

import java.io.Serializable;

public class User  implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	
	 private long id;
	
	 private String login;
	 private String password;
	 private String accountType;
	 private String assignedCourseID;
	 

	public User() {
		super();
	}
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public User(String login, String password, String accountType, String assignedCourseID) {
		super();
		this.login = login;
		this.password = password;
		this.accountType = accountType;
		this.assignedCourseID=assignedCourseID;
	}
	
	public User(long id, String login, String password, String accountType) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.accountType = accountType;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
		
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAssignedCourse() {
		return assignedCourseID;
	}
	public void setAssignedCourse(String assignedCourseID) {
		this.assignedCourseID=assignedCourseID;
	}
	@Override
	public String toString() {
		return "(id=" + id + ") " + login + ", " + accountType + assignedCourseID ;
	}	
}
