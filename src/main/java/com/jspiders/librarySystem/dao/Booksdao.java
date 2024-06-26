package com.jspiders.librarySystem.dao;

import java.util.List;
import java.util.Scanner;

import com.jspiders.librarySystem.dto.Books;
import com.jspiders.librarySystem.dto.Books_Students;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class Booksdao {
	public static void bookAdd() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Books book=new Books();
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter book name");
		String name=scn.next();
		System.out.println("Enter book author");
		String author=scn.next();
		System.out.println("Ente book genre");
		String genre=scn.next();
		
		book.setBookName(name);
		book.setBookAuthor(author);
		book.setBookGenre(genre);
		manager.persist(book);
		transaction.commit();
		
	}
	public static void showDetails() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter book name");
		String name=scn.next();
		List<Books> resultList = manager.createNativeQuery("Select * from books where bookName like '%"+name+"%' ;",Books.class).getResultList();
		System.out.println("Book Details are:\n");
		for (Object object: resultList) {
			Books books = (Books) object;
			System.out.println("Book Id:"+books.getBookId());
			System.out.println("Book Name:"+books.getBookName());
			System.out.println("Book Genre:"+books.getBookGenre());
			System.out.println("Book Author:"+books.getBookAuthor());
			
		}
		
	}
	public static void remove() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the book id");
		int id=scn.nextInt();
		transaction.begin();
		Books books = manager.find(Books.class, id);
		manager.remove(books);
		transaction.commit();
		
	}
	
	public static boolean checkBook(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		Books find = manager.find(Books.class, bid);
		if(find!=null)
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
