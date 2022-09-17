package com.dashboard.dao;

import java.util.List;

import com.dashboard.domain.Course;

public interface DashboardDAO {	
	
    List<Course> getAllCoursesById(String id);
    List<Course> getCourseByUserCourseId(String id);
    List<Course> getAllCourses();
    boolean insertCourse(Course course);
    boolean updateCourse(Course course);
    boolean deleteCourse(String id);

}
