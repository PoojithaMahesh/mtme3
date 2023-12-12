package manytoomanye3.controller;

import java.util.ArrayList;
import java.util.List;

import manytoomanye3.dao.CoursesDao;
import manytoomanye3.dao.StudentDao;
import manytoomanye3.dto.Courses;
import manytoomanye3.dto.Student;

public class StudentCoursesController {
public static void main(String[] args) {
	Courses courses1=new Courses();
	courses1.setId(100);
	courses1.setName("Java");
	courses1.setFees(20000);
	
	Courses courses2=new Courses();
	courses2.setId(200);
	courses2.setName("Advancejava");
	courses2.setFees(50000);
	
	Courses courses3=new Courses();
	courses3.setId(300);
	courses3.setName("SQL");
	courses3.setFees(10000);
	
	
	Student student1=new Student();
	student1.setId(1);
	student1.setName("venkata");
	student1.setAddress("tirupathi");
	
	List<Courses> coursesOfPrasanna=new ArrayList<Courses>();
	coursesOfPrasanna.add(courses2);
	coursesOfPrasanna.add(courses3);
	
	student1.setCourses(coursesOfPrasanna);
	
	Student student2=new Student();
	student2.setId(2);
	student2.setName("saisri");
	student2.setAddress("Dubai");
	student2.setCourses(coursesOfPrasanna);
	
	Student student3=new Student();
	student3.setId(3);
	student3.setName("jeevitha");
	student3.setAddress("bang");

	List<Courses> coursesJeevi=new ArrayList<Courses>();
	coursesJeevi.add(courses1);
	coursesJeevi.add(courses2);
	coursesJeevi.add(courses3);
	
	student3.setCourses(coursesJeevi);
	
	CoursesDao coursesDao=new CoursesDao();
	coursesDao.saveCourses(courses1);
	coursesDao.saveCourses(courses2);
	coursesDao.saveCourses(courses3);
	
	
	StudentDao  studentDao=new StudentDao();
	studentDao.saveStudent(student1);
	studentDao.saveStudent(student2);
	studentDao.saveStudent(student3);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
