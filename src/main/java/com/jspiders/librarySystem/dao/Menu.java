package com.jspiders.librarySystem.dao;

import java.util.Scanner;

public class Menu {
	public static void menu() {
		int ch;
		Scanner scn=new Scanner(System.in);
		do {
			System.out.println("use as:\n1.student\n2.librarian\n3.exit");
			ch=scn.nextInt();
			switch(ch)
			{
			case 1:
				int a;
				do {
					System.out.println("1.student Register\n2.student Login\n3.Go Back");
					a=scn.nextInt();
					switch(a)
					{
					case 1:
						Studentdao.StudentRegister();
						break;
					case 2:
					Studentdao.StudentLogin();
					break;
					case 3:
						break;
					default:
						System.out.println("enter the correct option");
					}
				}while(a!=3);
				break;
			case 2:
				int b;
				do {
					System.out.println("1.librarian Register\n2.librarian Login\n3.Go Back");
					b=scn.nextInt();
					switch(b)
					{
					case 1:
						Librariandao.libRegister();
						break;
					case 2:
						Librariandao.libLogin();
						break;
					case 3:
						break;
					default:
						System.out.println("Enter the correct option");
					}
					
				}
				while(b!=3);
				break;
			case 3:
				break;
			}
		}while(ch!=3);
	}
}
