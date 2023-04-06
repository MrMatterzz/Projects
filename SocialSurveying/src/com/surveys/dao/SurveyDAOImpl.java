package com.surveys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.surveys.DBConnectionManager;
import com.surveys.domain.Survey;

public class SurveyDAOImpl implements SurveyDAO {
	
	Connection connection;
	
	public SurveyDAOImpl(){
		DBConnectionManager connectionManager;
		try {
			connectionManager = new DBConnectionManager();
			this.connection = connectionManager.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Survey> getAllSubmissionsById(int id) {
		try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM submissions WHERE submission_ID=?"))
	        {
	            ps.setInt(1, id);	            
	            ResultSet rs = ps.executeQuery();	            
	            List<Survey> surveys = new ArrayList<>(); 
	            while(rs.next())
	            {
                   Survey survey = extractSubmissionFromResultSet(rs);
                   surveys.add(survey);  
	            }
	            return surveys; 
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	      return null;
	}     
	@Override
	public List<Survey> getSubmissionsByUserRegion(String userRegion) {
	        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM submission WHERE userRegion=?"))
	        {
	        	ps.setString(1, userRegion);	            
	            ResultSet rs = ps.executeQuery();
	            
	            List<Survey> surveies = new ArrayList<>(); 

	            while(rs.next())
	            {
                   Survey survey = extractSubmissionFromResultSet(rs);
                   surveies.add(survey);  
	            }
	            return surveies; 
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	      return null;
	}     
	@Override
	public List<Survey> getAllSubmissions() {
	        try (
	        	 Statement stmt = connection.createStatement();
		         ResultSet rs = stmt.executeQuery("SELECT * FROM submissions");
	        		)
	        	{	    	  
		            
		            List<Survey> surveys = new ArrayList<>(); 

		            while(rs.next())
		            {
	                   Survey survey = extractSubmissionFromResultSet(rs);
	                   surveys.add(survey);  
		            }
		            
		            return surveys; 
		            
		        } catch (SQLException ex) {
		            ex.printStackTrace();

		        }

		      return null;
	}

	@Override
	public boolean insertSubmission(Survey survey) {
        try (
            PreparedStatement ps = connection.prepareStatement("INSERT INTO submissions(userEmail, submission_Date, userAge, userRegion, answers) VALUES (?, ?, ?, ?, ?)");
        	)
       	{
	        ps.setString(1, survey.getUserEmail());
            ps.setString(2, survey.getSubmissionDate());
            ps.setInt(3, survey.getUserAge());
            ps.setString(4, survey.getUserRegion());
            ps.setString(5, survey.getAnswers());

	        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;
	}

	@Override
	public boolean updateSubmission(Survey survey) {
		
        //try-with-resources 
       try (//Connection connection = ConnectionFactory.getConnection();
    		PreparedStatement ps = connection.prepareStatement("UPDATE submissions set userEmail=?, submission_Date=?, userAge=?, userRegion=?, answers=? WHERE submission_ID=?");
	      )
	    {   
    	   ps.setString(1, survey.getUserEmail());
           ps.setString(2, survey.getSubmissionDate());
           ps.setInt(3, survey.getUserAge());
           ps.setString(4, survey.getUserRegion());
           ps.setString(5, survey.getAnswers()); 
           ps.setInt(6, survey.getSubmission_ID());
            
	        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

	@Override
	public boolean deleteSubmission(int id) {
		  //try-with-resources 
	       try (//Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement("DELETE FROM submissions WHERE id=?");
		      )
		    {   
	            ps.setInt(1, id);  
		        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE
		      if(i == 1) {
		        return true;
		      }
		    } catch (SQLException ex) {

		        ex.printStackTrace();
		    }
		    return false;
	}

	private Survey extractSubmissionFromResultSet(ResultSet rs) throws SQLException {

		 Survey survey = new Survey();
         survey.setSubmission_ID(rs.getInt("submission_ID"));
         survey.setUserEmail( rs.getString("userEmail") );
         survey.setSubmission_Date( rs.getString("submission_Date") );   
         survey.setUserAge(rs.getInt("userAge"));
         survey.setUserRegion( rs.getString("userRegion") ); 
         survey.setAnswers(rs.getString("answers") );
         return survey;
	}
}
