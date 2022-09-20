package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Employee;

public class CRUD_OperationDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session=null;
	Transaction tx=null;
	
	public void insertRecord(Employee e1)
	{
			session =factory.getCurrentSession();
			tx=session.beginTransaction();
			session.save(e1);
			tx.commit();
	}
	public void deleteRecord()
	{
			session =factory.getCurrentSession();
			tx=session.beginTransaction();
			session.createQuery("delete from employee where id = "+1).executeUpdate();
			tx.commit();
	}
	public void updateRecord()
	{
			session =factory.getCurrentSession();
			tx=session.beginTransaction();
			//session.createQuery("update employee set"+ +"where id = "+1).executeUpdate();
			tx.commit();
	}
	public void ViewRecord()
	{
			session =factory.getCurrentSession();
			tx=session.beginTransaction();
			Employee employee=session.get(Employee.class, 1);
			System.out.println(employee);
			tx.commit();
	}
	public void viewAllRecord()
	{
			session =factory.getCurrentSession();
			tx=session.beginTransaction();
			List<Employee> employee=session.createQuery("from employee").list();
			for(Employee emp:employee)
			{
				System.out.println(emp);
			}
			tx.commit();
	}
	
}
