package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Employee;

public class CRUD_OperationDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = null;
	Transaction tx = null;

	public void insertRecord(Employee e1) {
		session = factory.getCurrentSession();
		tx = session.beginTransaction();
		session.save(e1);
		System.out.println("Insert Record Successfully");
		tx.commit();
	}

	public void deleteRecord(int id) {
		session = factory.getCurrentSession();
		tx = session.beginTransaction();
		session.createQuery("delete from Employee where id = " + id).executeUpdate();
		System.out.println("Delete Record Successfully");
		tx.commit();
	}

	public void updateRecord(String name,int id) {
		session = factory.getCurrentSession();
		tx = session.beginTransaction();
		session.createQuery("update Employee set name = '"+name+"' where id = "+id).executeUpdate();
		System.out.println("update Record Successfully");
		tx.commit();
	}

	public void viewRecord(int id) {
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			System.out.println(employee);
			
			tx.commit();
		} catch (Exception e) {
			System.out.println("Invalid ID ");
		}
	}

	public void viewAllRecord() {
		session = factory.getCurrentSession();
		tx = session.beginTransaction();
		List<Employee> employees = session.createQuery("from Employee").list();
		for (Employee emp : employees) {
			System.out.println(emp);
		}
		tx.commit();
	}

	public void closeall()
	{
		session.close();
		factory.close();
	}
}
