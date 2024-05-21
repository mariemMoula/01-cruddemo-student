package com.mimilearning.cruddemo;

import com.mimilearning.cruddemo.dao.StudentDao;
import com.mimilearning.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.SplittableRandom;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
//			createStudent(studentDao);
			createMultipleStudents(studentDao);
//			readStudent(studentDao);
//			queryForStudents(studentDao);
//			queryForStudentsByLastName(studentDao);
//			updateStudent(studentDao);
//			deleteStudent(studentDao);
//			deleAllStudents(studentDao);
		};
	}

	private void deleAllStudents(StudentDao studentDao) {
		System.out.println("/*********************************************************************/");
		System.out.println("Deleting all students ....");
		int deletedrows= studentDao.deleteAll();
		System.out.println("Deleted trows count: "+deletedrows);
		System.out.println("/*********************************************************************/");

	}

	private void deleteStudent(StudentDao studentDao) {
		int theId = 1 ;
		System.out.println("/*********************************************************************/");
		System.out.println("Deleting student with id: "+theId);
		System.out.println("/*********************************************************************/");
		studentDao.delete(theId);
	}

	private void updateStudent(StudentDao studentDao) {
		// retrive student based on the id : primary key
		System.out.println("/*********************************************************************/");
		int studentId = 1;
		System.out.println("Getting the student with id: "+studentId);
		Student myStudent = studentDao.findById(studentId);
		System.out.println(myStudent);
		System.out.println("/*********************************************************************/");
		// change first name to Scooby
		System.out.println("Updating student ...");
		myStudent.setFirstName("Jho n");
		// update the student
		studentDao.update(myStudent);
		// display the updated student
		System.out.println("/*********************************************************************/");
		System.out.println("Updated student version:  "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		// get a list of students
		List<Student> theStudents = studentDao.findByLastname("Doe");
		// dispplay list of students
		for(Student tempStudent : theStudents){
			System.out.println("/*********************************************************************/");
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		//get a list of students
		List<Student> theStudents= studentDao.findAll();   
		// display that list of students 
		for (Student tempStudent : theStudents) {
			System.out.println("/*********************************************************************/");
			System.out.println(tempStudent);

		}
		
	}

	private void readStudent(StudentDao studentDao) { //Read operation
		// create a student object
		System.out.println("/*********************************************************************/");
		System.out.println("Creating new student object ....");
		System.out.println("/*********************************************************************/");
		Student tempStudent0 = new Student("Bonita", "Gomez", "yyy@gamil.com");
		// save the student
		System.out.println("/*********************************************************************/");
		System.out.println("Saving the students  ....");
		System.out.println("/*********************************************************************/");
		studentDao.save(tempStudent0);
		// display id of the saved student
		int theID = tempStudent0.getId();
		System.out.println("/*********************************************************************/");
		System.out.println("Saved student  . Generated id: "+ theID);
		System.out.println("/*********************************************************************/");
		// retrieve student based on the id : primary key
		System.out.println("/*********************************************************************/");
		System.out.println("Retrieving the student with the id : "+theID);
		Student myStudent = studentDao.findById(theID);
		System.out.println("/*********************************************************************/");
		// display student
		System.out.println("Found the student:  "+myStudent);
	}

	private void createMultipleStudents(StudentDao studentDao) {
		// create multiple students
		System.out.println("/*********************************************************************/");
		System.out.println("Creating new student object ....");
		System.out.println("/*********************************************************************/");
		Student tempStudent1 = new Student("Jhon", "Doe", "xyx@gamil.com");
		Student tempStudent2 = new Student("Lucy", "Sprouze", "yyx@gamil.com");
		Student tempStudent3 = new Student("Katy", "Cunt", "zzx@gamil.com");
		// save the student object
		System.out.println("Saving the students  ....");
		System.out.println("/*********************************************************************/");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);
	}

	private void createStudent(StudentDao studentDao) {
		// create the student object
		System.out.println("/*********************************************************************/");
		System.out.println("Creating new student object ....");
		System.out.println("/*********************************************************************/");
		Student tempStudent = new Student("Paul", "Doe", "xxx@gamil.com");
		// save the student object
		System.out.println("/*********************************************************************/");
		System.out.println("Saving the student  ....");
		System.out.println("/*********************************************************************/");
		studentDao.save(tempStudent);
		// display the id of the saved student
		System.out.println("/*********************************************************************/");
		System.out.println("Saved student  . Generated id: "+ tempStudent.getId());
		System.out.println("/*********************************************************************/");
	}

}
