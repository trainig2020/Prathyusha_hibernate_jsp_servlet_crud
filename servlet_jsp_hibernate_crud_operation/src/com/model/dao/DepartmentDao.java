package com.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.dto.Department;
import com.util.HibernateUtil;

public class DepartmentDao {

	public String createDepartment(Department dept) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(dept);
		String result ="Record Inserted Successfully";
		session.getTransaction().commit();
		//session.close();

		return result;
	}

	public String updateDepartment(Department dept) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(dept);
		String result ="Record Updated Successfully";
		session.getTransaction().commit();
		session.close();
		return result;
		
	}

	public String deleteDepartment(int deptid) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Department d=(Department) session.get(Department.class, deptid);
		session.delete(d);
		session.getTransaction().commit();
		session.close();
		return "result";
	}

	public List<Department> getAllDepartments() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Department");
		List Department = query.list();
		for (Object object : Department) {
			System.out.println(object.toString());
		}
//		String Result= "All Department Details Are:";
		session.getTransaction().commit();
		//session.close();
		return Department;
	}
	
	public Department getDepartment(int deptid){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Department d=(Department) session.get(Department.class, deptid);
		session.getTransaction().commit();
		session.close();
		return d;
	}

}
