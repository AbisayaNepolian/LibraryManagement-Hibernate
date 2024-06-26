package com.jspiders.librarySystem.dao;

import java.util.List;
import java.util.Scanner;

import com.jspiders.librarySystem.dto.Librarian;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Librariandao {
	public String name;
	public String password;
	public static void libRegister() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Librarian l=new Librarian();
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter librarian name");
		String name=scn.next();
		System.out.println("Enter librarian password");
		String password=scn.next();
		
		l.setLibName(name);
		l.setLibPassword(password);
		manager.persist(l);
		transaction.commit();
		
	}
	public static void libLogin() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter librarian name");
		String name=scn.next();
		System.out.println("Enter librarian pasword");
		String password=scn.next();
		
		List<Librarian> resultList = manager.createNativeQuery("Select * from librarian where libname='"+name+"';",Librarian.class).getResultList();
		if(resultList.isEmpty())
		{
			System.out.println("Entered name is invalid");
			System.out.println();
			
		}
		else
		{
			for (Librarian librarian : resultList) {
				if(name.equals(librarian.getLibName()) && password.equals(librarian.getLibPassword()))
				{
					System.out.println("Login sucess");
					LibrarianOperation.menu();
					
				}
				else
				{
					System.out.println("incorrect credentials");
				}
			}
		}
	}
}
