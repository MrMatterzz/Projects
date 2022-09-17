package com.dashboard.dao;

import java.util.List;

import com.dashboard.domain.User;

public interface UserDAO {	
	
    User getUserById(long id);
    User getUserByNameAndPassword(String login, String password);
    List<User> getAllUsers();
	List<User> getUsersByAccountType(String accountType);
    boolean insertUser(User user);
    boolean updateUserPassword(User user);
    boolean deleteUser(long id);


}
