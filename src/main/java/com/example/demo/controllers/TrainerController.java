package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;
import com.example.demo.services.TrainerServices;

@Controller
public class TrainerController 
{
	@Autowired
	TrainerServices tService;
	
	
	@PostMapping("/addCourse")
	public String postMethodName(@ModelAttribute Course course) 
	{
		if(tService.getCourse(course.getCourseId()) == false)
		{
			tService.addCourse(course);
			System.out.println("Course is added");
		}
		else {
			System.out.println("Course is already exist");
		}		
		return "trainerHome";
	}
	
	@PostMapping("/addLesson")
	public String addLesson (@RequestParam("courseId")int courseId,
			@RequestParam("lessonId")int lessonId,
			@RequestParam("lessonName")String lessonName,
			@RequestParam("topics")String topics,
			@RequestParam("link")String link) {
		
		Course course=tService.getCourseDetails(courseId);
		
		Lesson lesson=new Lesson(lessonId,lessonName,topics,link,course);
		tService.addLesson(lesson);
		
		course.getLessons().add(lesson);
		
		tService.saveCourse(course);
		
		return "/trainerHome";
	}
}
