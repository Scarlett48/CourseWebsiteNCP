package com.cwbackend.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDBUtil studentDBUtil;
	private InstructorDBUtil instructorDBUtil;
	
	@Resource(name="jdbc/cw_backend_db")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our DButil and pass in the connection pool / datasource
		try {
			studentDBUtil = new StudentDBUtil(dataSource);
			instructorDBUtil = new InstructorDBUtil(dataSource);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
			
			// read the value of command parameter from the html/jsp page
			String theCommand = request.getParameter("command");
			
			//if the command is missing do nothing
			if(theCommand == null) {
				return;
			}
			
			//route to appropriate method
			switch(theCommand) {
			
			case "CHECK":
				checkUser(request, response);
				break;
			
			case "ADD_TO_DB":
				String role = request.getParameter("role");
				if (role.equals("student"))
					insertStudent(request, response);
				else
					insertInstrcutor(request, response);
				break;
				
			case "UPDATE_Student":
				updateStudent(request, response);
				break;
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read the parameters to know email and password
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		RequestDispatcher requestDispatcher;
		PrintWriter out = response.getWriter();
		
		//check if user exists in database
		if(studentDBUtil.checkStudent(email) || instructorDBUtil.checkInstructor(email)) { 
			requestDispatcher = request.getRequestDispatcher("/profile.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User does not exist!');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// read the parameters required for updation
		String attr = request.getParameter("attribute");
		String val = request.getParameter("attribute_value");
		String email = request.getParameter("email");
		
		studentDBUtil.updateStudent(attr, val, email);
		
	}

	private void insertInstrcutor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read instructor info from FORM data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		// check if the given email already exists in database
		if(instructorDBUtil.checkInstructor(email)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Instrcutor already exists!');");
			out.println("location='signup.jsp';");
			out.println("</script>");
		}
		
		else {
			//create a new student object
			Instructor theInstructor = new Instructor(email, name, password);
				
			//add the student to the database
			instructorDBUtil.insertInstructor(theInstructor);
	
			//route back to login page
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Registered your account!');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
		
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from FORM data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		// check if the given email already exists in database
		if(studentDBUtil.checkStudent(email)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User already exists!');");
			out.println("location='signup.jsp';");
			out.println("</script>");
		}
		
		else {
			//create a new student object
			Student theStudent = new Student(email, name, password);
				
			//add the student to the database
			studentDBUtil.insertStudent(theStudent);
	
			//route back to login page
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Registered your account!');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
	}

}
