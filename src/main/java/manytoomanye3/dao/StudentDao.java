package manytoomanye3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import manytoomanye3.dto.Student;

public class StudentDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void saveStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	
	
	public void findStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
//			id is present
			System.out.println(dbStudent);
		}else {
			System.out.println("sorry id is not present");
		}
	}
	
	
	public void deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
//			id is present
			EntityTransaction  entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbStudent);
			entityTransaction.commit();
		}else {
			System.out.println("sorry id is not present");
		}
	}
		
	
	
	public void updateStudent(int id,Student student) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			student.setId(id);
			student.setCourses(dbStudent.getCourses());
			entityManager.merge(student);
			entityTransaction.commit();
		}else {
//			id is not present
			System.out.println("id is not present");
		}
	}
	
	
	
	
}
