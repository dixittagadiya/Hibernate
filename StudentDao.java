package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.Student;

public class StudentDao {
	SessionFactory sf = null;
	public StudentDao() {

		sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	
	}
	
	public int addOrUpdate(Student st) 
	{
		int i = 0;
		Transaction tx = null;
		
		try {
			Session s = sf.openSession();
			tx = s.beginTransaction();
			s.saveOrUpdate(st);
			i = 1;
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			i=0;
			tx.rollback();
		}
		
		return i;
	}
	
	public List<Student> viewAllStudent() 
	{
		List<Student> st = new ArrayList();
		Transaction tx = null;
		
		try {
			Session s = sf.openSession();
			tx = s.beginTransaction();
			st = s.createQuery("from Student").list();
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return st;
	}
	
	public int deleteStudent(int id) 
	{
		int i = 0;
		Transaction tx = null;
		try {
			Session s = sf.openSession();
			tx = s.beginTransaction();
			Student st = s.load(Student.class, id);
			s.delete(st);
			i = 1;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			i = 0;
			tx.rollback();
		}
		
		return i;
	}
	
	public Student getById(int id) {
		Student st = null;
		Transaction tx = null;
		
		try {
			Session s = sf.openSession();
			tx = s.beginTransaction();
			st = s.load(Student.class, id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return st;
		

	}
}
