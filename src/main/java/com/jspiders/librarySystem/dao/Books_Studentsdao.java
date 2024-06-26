package com.jspiders.librarySystem.dao;

import java.util.List;

import com.jspiders.librarySystem.dto.Books;
import com.jspiders.librarySystem.dto.Books_Students;
import com.jspiders.librarySystem.dto.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Books_Studentsdao {
	public static void bookIssue(int bId,int sId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Books_Students bs=new Books_Students();
		bs.setBookId(bId);
		bs.setStuId(sId);
		if(Booksdao.checkBook(bId))
		{
		if(check(bId, sId))
		{
			
			transaction.begin();
			manager.persist(bs);
			transaction.commit();
		}
		else
		{
			System.out.println("You have already Issued this book...!!");
		}
		}
		else
		{
			System.out.println("No book found...");
			
		}
		
	}
	public static void RemoveIssue(int student_Id,int book_Id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		int sno = 0;
		List<Books_Students> resultList = manager.createNativeQuery("Select * from books_students where bookId='"+book_Id+"and studId="+student_Id+"';",Books_Students.class).getResultList();
		for (Books_Students books_Students : resultList) {
		 sno = books_Students.getsNo();
		}
		transaction.begin();
		Books_Students find = manager.find(Books_Students.class, sno);
		manager.remove(find);
		
		transaction.commit();
		
	}
	public static boolean check(int bid,int sid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		List<Books_Students> resultList = manager.createNativeQuery("Select * from books_students where bookId='"+bid+"and stuId="+sid+"';",Books_Students.class).getResultList();
		if(resultList.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void IssueDetails() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = entityManagerFactory.createEntityManager();
		List<Books_Students> resultList = manager.createNativeQuery("Select * from books_students ",Books_Students.class).getResultList();
		for (Books_Students books_Students : resultList) {
			int sid=books_Students.getStuId();
			int bid=books_Students.getBookId();
			Books books = manager.find(Books.class,bid);
			Student student = manager.find(Student.class, sid);
			System.out.println("Student & Book details are: ");
			System.out.println("Student name: "+student.getStuName());
			System.out.println("Student rollno: "+student.getStuRollno());
			System.out.println("Student id: "+student.getStuId());
			System.out.println("Book name: "+books.getBookName());
			System.out.println("Book id: "+books.getBookId());
			
			
			
			
		}
	}
}
