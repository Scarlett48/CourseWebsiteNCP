package com.cwbackend.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CoursesDBUtil {
	
	private DataSource dataSource;
	
	public CoursesDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Courses> getCourses() throws Exception {
		List<Courses> courses = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * from courses";
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while(myRs.next()) {
				
				// retrieve data from result set row
				String title = myRs.getString("course_title");
				String link = myRs.getString("course_link");
				String desc = myRs.getString("course_description");
				String assignment = myRs.getString("course_assignment");
				
				// create new student object
				Courses tempCourse = new Courses(title, link, desc, assignment);
				
				// add it to the list of students
				courses.add(tempCourse);
			}
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
		return courses;
	}
	
	public List<String> getCoursesTitle() throws Exception {
		List<String> titles = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * from courses";
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while(myRs.next()) {
				// retrieve data from result set row
//				System.out.println(myRs.getString(2));
				String course_title = myRs.getString("course_title");
				
				// add it to the list of titles
				titles.add(course_title);
			}
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
		return titles;
	}
	
	public List<String> getCoursesLink() throws Exception {
		List<String> links = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * from courses";
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while(myRs.next()) {
				// retrieve data from result set row
//				System.out.println(myRs.getString(2));
				String course_link = myRs.getString("course_link");
				
				// add it to the list of titles
				links.add(course_link);
			}
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
		return links;
	}
	
	public List<String> getCoursesDescription() throws Exception {
		List<String> descriptions = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * from courses";
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while(myRs.next()) {
				// retrieve data from result set row
				String course_description = myRs.getString("course_description");
				
				// add it to the list of titles
				descriptions.add(course_description);
			}
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
		return descriptions;
	}
	
	public boolean checkCourse(String title) throws Exception {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * from courses WHERE course_title = \'" + title + "\'";
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			if (myRs.next())
				return true;
			else
				return false;
		}
		finally {
			close(myConn, myStmt, myRs);
		}
	}
	
	public void insertCourse(Courses theCourse) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get DB connection
			myConn = dataSource.getConnection();
			
			// create SQL for insert
			String sql = "INSERT INTO courses "
					   + "(course_title, course_link, course_description, course_rating, course_assignment) "
					   + "VALUES (?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the course
			myStmt.setString(1, theCourse.getTitle());
			myStmt.setString(2, theCourse.getLink());
			myStmt.setString(3, theCourse.getDescription());
			myStmt.setDouble(4, 0.0);
			myStmt.setString(5, theCourse.getAssignment());
			
			// execute SQL insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		

	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void insertQuestion(Question theQuestion) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get DB connection
			myConn = dataSource.getConnection();
			
			// create SQL for insert
			String sql = "INSERT INTO questions "
					   + "(course_title, question, options, correct_option) "
					   + "VALUES (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the parameter values for the course
			myStmt.setString(1, theQuestion.getCourse_title());
			myStmt.setString(2, theQuestion.getQuestion());
			myStmt.setString(3, theQuestion.getOptions());
			myStmt.setString(4, theQuestion.getCorrect_option());
			
			// execute SQL insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public List<Question> getQuestions(String title) throws SQLException {
		List<Question> questions = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * from questions WHERE course_title = '"+title+"'";
			System.out.println(sql);
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while(myRs.next()) {
				
				// retrieve data from result set row
				String question = myRs.getString("question");
				String options = myRs.getString("options");
				String correct_option = myRs.getString("correct_option");
				
				// create new student object
				Question tempQuestion = new Question(title, question, options, correct_option);
				
				// add it to the list of students
				questions.add(tempQuestion);
			}
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
		return questions;
	}

}
