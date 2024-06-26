package com.jspiders.librarySystem.dao;

import java.util.List;
import java.util.Scanner;

import com.jspiders.librarySystem.dto.Librarian;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LibrarianOperation {
	
	public static void menu() {
		int ch;
		Scanner scn=new Scanner(System.in);
		do {
			System.out.println("1.Add books\n2.Remove Books\n3.Book Details\n4.Issue Details\n5.Remove Issue\n6.Logout");
			 ch=scn.nextInt();
			switch(ch)
			{
			case 1:
				Booksdao.bookAdd();
				break;
			case 2:
				Booksdao.remove();
				break;
			case 3:
				Booksdao.showDetails();
				break;
			case 4:
				Books_Studentsdao.IssueDetails();
				break;
			case 5:
				System.out.println("Enter book_Id");
				int bid=scn.nextInt();
				System.out.println("Enter Student_Id");
				int sid=scn.nextInt();
				Books_Studentsdao.RemoveIssue( sid,bid);
				break;
			case 6:
				break;
			}
		}while(ch!=6);
	}
			
	
}
