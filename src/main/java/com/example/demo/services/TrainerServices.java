package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;

public interface TrainerServices 
{
	public String addCourse(Course course);
	
	public String saveCourse(Course course);
	
	public String addLesson(Lesson lesson);
	
	public List<Course> courseList();
	
	public boolean getCourse(int id);
	
	public Course getCourseDetails(int id);
	
	public boolean getLesson(int id);
	

}
