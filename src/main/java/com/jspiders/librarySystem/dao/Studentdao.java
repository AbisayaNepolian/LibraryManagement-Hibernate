package com.jspiders.librarySystem.dao;

import java.util.List;
import java.util.Scanner;

import com.jspiders.librarySystem.dto.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Studentdao {
	public static String rollno;
	public static String password;
	
	public static void StudentRegister() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Student s=new Student();
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter student name");
		String name=scn.next();
		System.out.println("Enter student rollno");
		String rollno=scn.next();
		System.out.println("Enter student password");
		String password=scn.next();
		
		s.setStuName(name);
		s.setStuRollno(rollno);
		s.setStuPassword(password);
		manager.persist(s);
		transaction.commit();
		
	}
	public static void StudentLogin() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter student rollno");
		String rollno=scn.next();
		System.out.println("Enter student password");
		String password=scn.next();
		
		List<Student> resultList = manager.createNativeQuery("Select * from student where sturollno='"+rollno+"';",Student.class).getResultList();
		if(resultList.isEmpty())
		{
			System.out.println("Entered rollno is invalid");
			System.out.println();
		}
		else
		{
			for (Object object : resultList) {
			Student student=(Student) object;
				if(rollno.equals(student.getStuRollno())&& password.equals(student.getStuPassword()))
				{
					System.out.println("Login success");
					Studentdao.rollno=rollno;
					Studentdao.password=password;
					StudentOperation.menu();
				}
				else
				{
					System.out.println("invalid login");
				}
			}
		}
	}
}
