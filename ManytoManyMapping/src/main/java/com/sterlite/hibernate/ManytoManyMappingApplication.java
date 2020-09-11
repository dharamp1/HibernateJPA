package com.sterlite.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sterlite.hibernate.entities.Course;
import com.sterlite.hibernate.entities.Student;
import com.sterlite.hibernate.repos.CourseRepository;
import com.sterlite.hibernate.repos.StudentRepository;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 2nd Sep 2020
 */
@SpringBootApplication
public class ManytoManyMappingApplication implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManytoManyMappingApplication.class);
	
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private StudentRepository studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(ManytoManyMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Course c1 = new Course(101, "Java");
		Course c2 = new Course(201, "Spring Boot");
		
		Student s1 = new Student(11, "Gita Khanna");
		Student s2 = new Student(12, "Vijay Kumar");
		Student s3 = new Student(13, "Pranita Patil");
		
		List<Student> students1 = Arrays.asList(s1,s2);
		c1.setStudents(students1);
		
		List<Student> students2 = Arrays.asList(s1,s2,s3);
		c2.setStudents(students2);
		
		
		List<Course> courses = Arrays.asList(c1, c2);
		s1.setCourses(courses);
		s2.setCourses(courses);
		s3.setCourses(Arrays.asList(c2));
			
		c1 = courseRepo.save(c1);
		LOGGER.info("New course with id " + c1.getId() + " saved successfully!");
		c2 = courseRepo.save(c2);
		LOGGER.info("New course with id " + c2.getId() + " saved successfully!");
	
	}

}
