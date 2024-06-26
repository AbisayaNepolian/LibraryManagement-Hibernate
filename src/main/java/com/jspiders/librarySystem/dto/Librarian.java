package com.jspiders.librarySystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Librarian {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int libId;
	private String libName;
	private String libPassword;
	@Override
	public String toString() {
		return "Librarian [libId=" + libId + ", libName=" + libName + ", libPassword=" + libPassword + "]";
	}
	public int getLibId() {
		return libId;
	}
	public void setLibId(int libId) {
		this.libId = libId;
	}
	public String getLibName() {
		return libName;
	}
	public void setLibName(String libName) {
		this.libName = libName;
	}
	public String getLibPassword() {
		return libPassword;
	}
	public void setLibPassword(String libPassword) {
		this.libPassword = libPassword;
	}
	
}
