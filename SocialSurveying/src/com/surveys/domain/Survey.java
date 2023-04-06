package com.surveys.domain;

import java.io.Serializable;

public class Survey implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	
	 private int submission_ID;
	
	 private String userEmail;
	 private String submissionDate;
	 private int userAge;
	 private String userRegion;
	 private String answers;
	 

	public Survey() {
		super();
	}

	public Survey(String userEmail, String submission_Date, int userAge, String userRegion, String answers) {
		super();
		this.userEmail = userEmail;
		this.submissionDate = submission_Date;
		this.userAge = userAge;
		this.userRegion = userRegion;
		this.answers = answers;
	}
	
	public Survey(int submission_ID, String userEmail, String submission_Date, int userAge, String userRegion, String answers) {
		super();
		this.submission_ID = submission_ID;
		this.userEmail = userEmail;
		this.submissionDate = submission_Date;
		this.userAge = userAge;
		this.userRegion = userRegion;
		this.answers = answers;
	}
	
	
	public int getSubmission_ID() {
		return submission_ID;
	}
	public void setSubmission_ID(int submission_ID) {
		this.submission_ID = submission_ID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmission_Date(String submission_Date) {
		this.submissionDate = submission_Date;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge=userAge;
	}
	public String getUserRegion() {
		return userRegion;
	}
	public void setUserRegion(String userRegion) {
		this.userRegion = userRegion;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	
	@Override
	public String toString() {
		return "(id=" + submission_ID + ") " + userEmail + ", " + submissionDate + ", " + userRegion;
	}
	

	
	

	
}
