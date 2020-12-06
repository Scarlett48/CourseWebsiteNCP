package com.cwbackend.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CoursesDBUtil {
	
	private DataSource dataSource;
	
	public CoursesDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
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
	
	public void insertCourse(Courses theCourse) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get DB connection
			myConn = dataSource.getConnection();
			
			// create SQL for insert
			String sql = "INSERT INTO courses "
					   + "(id, title, link, description, rating, assignment) "
					   + "VALUES (?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the course
			myStmt.setString(1, theCourse.getId());
			myStmt.setString(2, theCourse.getTitle());
			myStmt.setString(3, theCourse.getLink());
			myStmt.setString(4, theCourse.getDescription());
			myStmt.setDouble(5, 0.0);
			myStmt.setString(6, theCourse.getAssignment());
			
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

}
