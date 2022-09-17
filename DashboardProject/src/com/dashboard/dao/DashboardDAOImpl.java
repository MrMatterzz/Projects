package com.dashboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dashboard.DBConnectionManager;
import com.dashboard.domain.Course;

public class DashboardDAOImpl implements DashboardDAO {
	
	Connection connection;
	
	public DashboardDAOImpl(){
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
	public List<Course> getAllCoursesById(String id) {
		try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM course WHERE id=?"))
	        {
	            ps.setString(1, id);	            
	            ResultSet rs = ps.executeQuery();	            
	            List<Course> courses = new ArrayList<>(); 
	            while(rs.next())
	            {
                   Course course = extractCourseFromResultSet(rs);
                   courses.add(course);  
	            }
	            return courses; 
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	      return null;
	}     
	@Override
	public List<Course> getCourseByUserCourseId(String userCourseId) {
	        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM course WHERE id=?"))
	        {
	        	ps.setString(1, userCourseId);	            
	            ResultSet rs = ps.executeQuery();
	            
	            List<Course> courses = new ArrayList<>(); 

	            while(rs.next())
	            {
                   Course course = extractCourseFromResultSet(rs);
                   courses.add(course);  
	            }
	            return courses; 
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	      return null;
	}     
	@Override
	public List<Course> getAllCourses() {
	        try (
	        	 Statement stmt = connection.createStatement();
		         ResultSet rs = stmt.executeQuery("SELECT * FROM course");
	        		)
	        	{	    	  
		            
		            List<Course> courses = new ArrayList<>(); 

		            while(rs.next())
		            {
	                   Course course = extractCourseFromResultSet(rs);
	                   courses.add(course);  
		            }
		            
		            return courses; 
		            
		        } catch (SQLException ex) {
		            ex.printStackTrace();

		        }

		      return null;
	}

	@Override
	public boolean insertCourse(Course course) {
        try (
            PreparedStatement ps = connection.prepareStatement("INSERT INTO course(id, title, professor, description) VALUES (?, ?, ?, ?)");
        	)
       	{
        	ps.setString(1, course.getId());
	        ps.setString(2, course.getTitle());
            ps.setString(3, course.getProfessor());
            ps.setString(4, course.getDescription());    

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
	public boolean updateCourse(Course course) {
		
        //try-with-resources 
       try (//Connection connection = ConnectionFactory.getConnection();
    		PreparedStatement ps = connection.prepareStatement("UPDATE course set title = ?, professor = ?, description= ? WHERE id=?");
	      )
	    {   
	        ps.setString(1, course.getTitle());
            ps.setString(2, course.getProfessor());
            ps.setString(3, course.getDescription());
            ps.setString(4, course.getId());  
            
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
	public boolean deleteCourse(String id) {
		  //try-with-resources 
	       try (//Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement("DELETE FROM course WHERE id=?");
		      )
		    {   
	            ps.setString(1, id);  
		        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE
		      if(i == 1) {
		        return true;
		      }
		    } catch (SQLException ex) {

		        ex.printStackTrace();
		    }
		    return false;
	}

	private Course extractCourseFromResultSet(ResultSet rs) throws SQLException {

		 Course course = new Course();
         course.setId(rs.getString("id"));
         course.setTitle( rs.getString("title") );
         course.setProfessor( rs.getString("professor") );                
         course.setDescription( rs.getString("description") );       
         return course;
	}
}
