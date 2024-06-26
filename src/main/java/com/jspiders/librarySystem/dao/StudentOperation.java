package com.jspiders.librarySystem.dao;

import java.util.List;
import java.util.Scanner;

import com.jspiders.librarySystem.dto.Books_Students;
import com.jspiders.librarySystem.dto.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentOperation {
	
	public static int rollno_id() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String rollno=Studentdao.rollno;
		List<Student> list = manager.createNativeQuery("Select * from student where stuRollno='"+rollno+"';",Student.class).getResultList();
		if(!list.isEmpty())
		{
			for (Student student : list) {
				int id=student.getStuId();
				return id;
			}
		}
		throw new IllegalArgumentException("rollno not present");
	}
	
	public static void menu() {
		Scanner scn=new Scanner(System.in);
		int ch;
		do {
			System.out.println("1.show Details\n2.Issue Book\n3.Log out");
			 ch=scn.nextInt();
			switch(ch) {
			case 1:
				Booksdao.showDetails();
				break;
			case 2:
				System.out.println("Enter id");
				int bookid=scn.nextInt();
				int sid = rollno_id();
				Books_Studentsdao.bookIssue(bookid, sid);
				break;
			case 3:
				break;
				default:
					System.out.println("Enter the correct value");
			}
			
			
		}
		while(ch!=3);
		
	}

}
