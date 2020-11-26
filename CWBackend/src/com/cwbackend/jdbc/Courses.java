package com.cwbackend.jdbc;

public class Courses {
	private String id;
	private String title;
	private String link;
	private String description;
	private double rating;
	private String assignment;
	
	public Courses(String title, String link, String description, String assignment) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.assignment = assignment;
	}

	public Courses(String id, String title, String link, String description, double rating, String assignment) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.description = description;
		this.rating = rating;
		this.assignment = assignment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", title=" + title + ", link=" + link + ", description=" + description
				+ ", rating=" + rating + ", assignment=" + assignment + "]";
	}
	
}
