package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.LessonRepository;
@Service
public class TrainerServicesImplementation implements TrainerServices
{
	@Autowired
	CourseRepository repoCourse;

	@Autowired
	LessonRepository repoLesson;

	@Override
	public String addCourse(Course course) 
	{

		repoCourse.save(course);
		return "Course is added";
	}

	@Override
	public String saveCourse(Course course) {
		repoCourse.save(course);
		return "Course saved successfully!";
	}

	@Override
	public String addLesson(Lesson lesson) 
	{

		repoLesson.save(lesson);
		return "Lesson is added";
	}

	@Override
	public List<Course> courseList() {
		return repoCourse.findAll();
	}

	@Override
	public boolean getCourse(int id) 
	{
		Course courseStatus = repoCourse.findById(id);
		if(courseStatus == null)
		{
			return false;
		}

		return true;
	}

	@Override
	public boolean getLesson(int id) 
	{
		Lesson lessonStatus = repoLesson.findById(id);
		if(lessonStatus == null)
		{
			return false;
		}
		return true;
	}

	@Override
	public Course getCourseDetails(int id) 
	{	
		return repoCourse.findById(id);
	}
}
