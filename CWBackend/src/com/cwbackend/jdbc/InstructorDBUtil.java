package com.cwbackend.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class InstructorDBUtil {
	
	private DataSource dataSource;
	
	public InstructorDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public void insertInstructor(Instructor theInstructor) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get DB connection
			myConn = dataSource.getConnection();
			
			// create SQL for insert
			String sql = "INSERT INTO instructors "
					   + "(email, name, password, rating) "
					   + "VALUES (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theInstructor.getEmail());
			myStmt.setString(2, theInstructor.getName());
			myStmt.setString(3, theInstructor.getPassword());
			myStmt.setDouble(4, 4.5);
			
			// execute SQL insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
	
	public boolean checkInstructor(String email) throws Exception {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create SQL statement
			String sql = "SELECT * FROM instructors WHERE email = \'" + email + "\'";
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
