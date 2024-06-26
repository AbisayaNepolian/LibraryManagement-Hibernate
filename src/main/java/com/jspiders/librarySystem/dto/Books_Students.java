package com.jspiders.librarySystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books_Students {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sNo;
	private int bookId;
	private int stuId;
	@Override
	public String toString() {
		return "Books_Students [sNo=" + sNo + ", bookId=" + bookId + ", stuId=" + stuId + "]";
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	
	
}
