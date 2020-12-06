package com.cwbackend.jdbc;

public class Question {
	private String course_title;
	private String question;
	private String options;
	private String correct_option;
	
	public Question(String course_title, String question, String options, String correct_option) {
		super();
		this.course_title = course_title;
		this.question = question;
		this.options = options;
		this.correct_option = correct_option;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getCorrect_option() {
		return correct_option;
	}

	public void setCorrect_option(String correct_option) {
		this.correct_option = correct_option;
	}

	@Override
	public String toString() {
		return "Question [course_title=" + course_title + ", question=" + question + ", options=" + options
				+ ", correct_option=" + correct_option + "]";
	}
	
}
