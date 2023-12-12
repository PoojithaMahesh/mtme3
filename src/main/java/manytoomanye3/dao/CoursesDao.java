package manytoomanye3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoomanye3.dto.Courses;
import manytoomanye3.dto.Student;

public class CoursesDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void saveCourses(Courses courses) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(courses);
		entityTransaction.commit();
	}
	public void findCourses(int id) {
		EntityManager entityManager=getEntityManager();
		Courses dbCourses=entityManager.find(Courses.class, id);
		if(dbCourses!=null) {
//			id is present
			System.out.println(dbCourses);
		}else {
			System.out.println("sorry id is not present");
		}
	}
	
	
	public void deleteCourses(int id) {
		EntityManager entityManager=getEntityManager();
		Courses dbCourses=entityManager.find(Courses.class, id);
		if(dbCourses!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbCourses);
			entityTransaction.commit();
		}else {
			System.out.println("sorry id is not present");
		}
	}
	
	public void updateCourses(int id,Courses courses) {
		EntityManager entityManager=getEntityManager();
		Courses dbCourses=entityManager.find(Courses.class, id);
		if(dbCourses!=null) {
//			id is  present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			courses.setId(id);
			entityManager.merge(courses);
			entityTransaction.commit();
		}else {
//			id is not present
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
}
