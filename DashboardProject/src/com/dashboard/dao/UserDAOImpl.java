package com.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dashboard.DBConnectionManager;
import com.dashboard.domain.User;

public class UserDAOImpl implements UserDAO {
	
	Connection connection;
	
	public UserDAOImpl(){
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
	public User getUserById(long id) {
	   // Connection connection = ConnectionFactory.getConnection();

          //try-with-resources 
        try (//Connection connection = ConnectionFactory.getConnection();
        	 Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);
        		)
        	{        
            if(rs.next())
            {            
            	return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
      return null;
	}
	@Override
	public User getUserByNameAndPassword(String login, String password) {
		   
            //try-with-resources 
	        try (//Connection connection = ConnectionFactory.getConnection();
	        	PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE login=? AND password=?"))
	        {
	            ps.setString(1, login);
	            ps.setString(2, password);
	            
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {
	             	return extractUserFromResultSet(rs);
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	      return null;
	}

	@Override
	public List<User> getUsersByAccountType(String accountType) {
	
		   //try-with-resources 
	        try (//Connection connection = ConnectionFactory.getConnection();
	        	 Statement stmt = connection.createStatement();
		         ResultSet rs = stmt.executeQuery("SELECT * FROM user Where accountType="+accountType);
	        		)
	        	{
		            List<User> users = new ArrayList<>(); 
		            while(rs.next())
		            {
		            	User user = extractUserFromResultSet(rs);
	                   users.add(user);  
		            }   
		            return users; 	            
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		      return null;
	}	
	@Override
	public List<User> getAllUsers() {
	
		   //try-with-resources 
	        try (//Connection connection = ConnectionFactory.getConnection();
	        	 Statement stmt = connection.createStatement();
		         ResultSet rs = stmt.executeQuery("SELECT * FROM user");
	        		)
	        	{	    	  		            
		            List<User> users = new ArrayList<>(); 
		            while(rs.next())
		            {
		            	User user = extractUserFromResultSet(rs);
	                   users.add(user);  
		            }	            
		            return users; 		            
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }

		      return null;
	}
	@Override
	public boolean insertUser(User user) {
				
		//try-with-resources 
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO user(login, password, accountType, assignedCourseID) VALUES (?, ?, ?, ?)"))
       	{     
	        ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAccountType());
            ps.setString(4, user.getAssignedCourse());
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
	public boolean updateUserPassword(User user) {		
        //try-with-resources 
       try (//Connection connection = ConnectionFactory.getConnection();
    		PreparedStatement ps = connection.prepareStatement("UPDATE user set password = ? WHERE id=?");
	      )
	    {   
	        ps.setString(1, user.getPassword());          
            ps.setLong(2, user.getId());  
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
	public boolean deleteUser(long id) {
		
		  //try-with-resources 
	       try (//Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE id=?");
		      )
		    {   
	            ps.setLong(1, id);  
		        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE
		      if(i == 1) {
		        return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return false;
	}

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {

		 User user = new User();
		 user.setId(rs.getLong("id"));
		// user.setName( rs.getString("name") );
		// user.setPassword( rs.getString("password") );                
		 user.setAccountType( rs.getString("accountType") );
		 user.setAssignedCourse(rs.getString("assignedCourseID"));
         return user;
	}
}
