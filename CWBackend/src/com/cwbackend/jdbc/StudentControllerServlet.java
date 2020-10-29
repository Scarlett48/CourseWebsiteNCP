package com.cwbackend.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	@Resource(name="jdbc/cw_backend_db")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student DButil and pass in the connection pool / datasource
		try {
			studentDBUtil = new StudentDBUtil(dataSource);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// read the value of command parameter from the html/jsp page
			String theCommand = request.getParameter("command");
			
			//if the command is missing do nothing
			if(theCommand == null) {
				return;
			}
			
			//route to appropriate method
			switch(theCommand) {
			
			case "ADD_TO_DB":
				String role = request.getParameter("role");
				if (role.equals("student"))
					insertStudent(request, response);
				else
					insertInstrcutor(request, response);
				break;
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void insertInstrcutor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
