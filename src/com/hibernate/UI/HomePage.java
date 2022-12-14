package com.hibernate.UI;

import java.util.Scanner;

import com.hibernate.dao.CRUD_OperationDAO;
import com.hibernate.model.Employee;

public class HomePage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch, id;
		String name, domain, location,updatevalue;
		long salary;
		CRUD_OperationDAO operation = new CRUD_OperationDAO();

		System.out.println("------Welcome to Hibernate Project------");
		System.out.println("-----We can Perform a CRUD operation------");

		do {
			System.out.println("1.Insert Employee record");
			System.out.println("2.View Employee record");
			System.out.println("3.View all the Employee record");
			System.out.println("4.Update Employee record");
			System.out.println("5.Delete Employee record");
			System.out.println("0.Exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("----- Insert record -----");
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the domain");
				domain = sc.next();
				System.out.println("Enter the location");
				location = sc.next();
				System.out.println("Enter the salary");
				salary = sc.nextLong();
				Employee emp = new Employee(name, domain, location, salary);
				operation.insertRecord(emp);
				break;
			case 2:
				System.out.println("----- View record -----");
				System.out.println("Enter the Id");
				id = sc.nextInt();
				operation.viewRecord(id);
				break;
			case 3:
				System.out.println("----- View All record -----");
				operation.viewAllRecord();
				break;
			case 4:
				System.out.println("----- Update record -----");
				System.out.println("Enter name for update :");
				name=sc.next();
				System.out.println("Enter the Id");
				id = sc.nextInt();
				operation.updateRecord(name,id);
				break;
			case 5:
				System.out.println("----- Delete record -----");
				System.out.println("Enter the Id");
				id = sc.nextInt();
				operation.deleteRecord(id);
				break;
			case 0:
				System.out.println("Thank You");
				operation.closeall();
				break;
			default:
				System.out.println("Invalid Choice");
			}
		} while (ch != 0);

	}

}
