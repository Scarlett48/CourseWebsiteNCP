package com.cwbackend.jdbc;

public class Student {
	
	private String email;
	private String name;
	private String password;
	private String bio;
	private String area_of_interest;
	private int no_courses_taken;
	
	public Student(String email, String name, String password, String bio, String area_of_interest,
			int no_courses_taken) {
		
		this.email = email;
		this.name = name;
		this.password = password;
		this.bio = bio;
		this.area_of_interest = area_of_interest;
		this.no_courses_taken = no_courses_taken;
	}

	public Student(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getArea_of_interest() {
		return area_of_interest;
	}

	public void setArea_of_interest(String area_of_interest) {
		this.area_of_interest = area_of_interest;
	}

	public int getNo_courses_taken() {
		return no_courses_taken;
	}

	public void setNo_courses_taken(int no_courses_taken) {
		this.no_courses_taken = no_courses_taken;
	}

	@Override
	public String toString() {
		return "Student [email=" + email + ", name=" + name + ", password=" + password + ", bio=" + bio
				+ ", area_of_interest=" + area_of_interest + ", no_courses_taken=" + no_courses_taken + "]";
	}
	
	
}
