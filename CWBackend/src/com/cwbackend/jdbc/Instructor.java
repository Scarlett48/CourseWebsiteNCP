package com.cwbackend.jdbc;

public class Instructor {
	private String email;
	private String name;
	private String password;
	private String about;
	private String area_of_expertise;
	private double ratings;
	
	public Instructor(String email, String name, String password, String about, String area_of_expertise,
			double ratings) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.about = about;
		this.area_of_expertise = area_of_expertise;
		this.ratings = ratings;
	}
	
	public Instructor(String email, String name, String password) {
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getArea_of_expertise() {
		return area_of_expertise;
	}

	public void setArea_of_expertise(String area_of_expertise) {
		this.area_of_expertise = area_of_expertise;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Instructor [email=" + email + ", name=" + name + ", password=" + password + ", about=" + about
				+ ", area_of_expertise=" + area_of_expertise + ", ratings=" + ratings + "]";
	}
	
	
}
