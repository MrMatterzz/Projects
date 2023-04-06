package com.surveys.dao;

import java.util.List;

import com.surveys.domain.Survey;

public interface SurveyDAO {	
	
    List<Survey> getAllSubmissionsById(int id);
    List<Survey> getSubmissionsByUserRegion(String userRegion);
    List<Survey> getAllSubmissions();
    boolean insertSubmission(Survey survey);
    boolean updateSubmission(Survey survey);
    boolean deleteSubmission(int id);

}
