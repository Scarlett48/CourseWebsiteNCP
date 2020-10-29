package com.cwbackend.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import java.sql.PreparedStatement;

public class StudentDBUtil {

	private DataSource dataSource;
	
	public StudentDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * from students";
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while(myRs.next()) {
				
				// retrieve data from result set row
				String email = myRs.getString("email");
				String name = myRs.getString("name");
				String password = myRs.getString("password");
				String bio = myRs.getString("bio");
				String area_of_interest = myRs.getString("area_of_interest");
				int no_courses_taken = myRs.getInt("no_courses_taken");
				
				// create new student object
				Student tempStudent = new Student(email, name, password, bio, area_of_interest, no_courses_taken);
				
				// add it to the list of students
				students.add(tempStudent);
			}
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
		return students;
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

	public void insertStudent(Student theStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get DB connection
			myConn = dataSource.getConnection();
			
			// create SQL for insert
			String sql = "INSERT INTO students "
					   + "(email, name, password, no_courses_taken) "
					   + "VALUES (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theStudent.getEmail());
			myStmt.setString(2, theStudent.getName());
			myStmt.setString(3, theStudent.getPassword());
			myStmt.setInt(4, 0);
			
			// execute SQL insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		

	}

	public boolean checkStudent(String email) throws Exception {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * from students WHERE email = \'" + email + "\'";
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
}
