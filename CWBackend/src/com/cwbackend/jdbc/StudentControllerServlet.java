package com.cwbackend.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDBUtil studentDBUtil;
	private InstructorDBUtil instructorDBUtil;
	RequestDispatcher requestDispatcher;
	
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
			
			case "CHECK_Login":
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
				
			case "ChangePassword":
				changePassword(request, response);
				break;
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read parameters
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String email = (String) session.getAttribute("email");
		String oldPassword = request.getParameter("oldPass");
		String newPassword = request.getParameter("newPass");
		
		List<Student> stu = studentDBUtil.getStudent(email);
		if (stu.get(0).getPassword().equals(oldPassword)) {
			studentDBUtil.updateStudent("password", newPassword, email);
			
			updateStudent(request, response);
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password has been successfully changed!');");
			out.println("location='profile.jsp';");
			out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Old password does not match!');");
			out.println("location='updateProfile.jsp';");
			out.println("</script>");
		}
		
	}

	private void checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read the parameters to know email and password
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//check if user exists in database
		if(studentDBUtil.checkStudent(email)){ 
			List<Student> stu = studentDBUtil.getStudent(email);
			if (stu.get(0).getPassword().equals(password)) {
				session.setAttribute("email", email);
				session.setAttribute("student_name", stu.get(0).getName());
				session.setAttribute("student_bio", stu.get(0).getBio());
				session.setAttribute("student_aoi", stu.get(0).getArea_of_interest());
				
				requestDispatcher = request.getRequestDispatcher("/profile.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Wrong password!');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}
		}
		else if(instructorDBUtil.checkInstructor(email)) {
			List<Instructor> ins = instructorDBUtil.getInstructor(email);
			if(ins.get(0).getPassword().equals(password)) {
				session.setAttribute("email", email);
				session.setAttribute("instructor_name", ins.get(0).getName());
				session.setAttribute("instructor_about", ins.get(0).getAbout());
				session.setAttribute("instructor_aoe", ins.get(0).getArea_of_expertise());
				session.setAttribute("instructor_rating", ins.get(0).getRatings());
				
				requestDispatcher = request.getRequestDispatcher("/profile.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Wrong password!');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User does not exist!');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
		
		
		
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		try {
		// read the parameters required for updation
		String attr = request.getParameter("updateAttribute");
		String val = request.getParameter("updateValue");
		
		System.out.println(attr + val);
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		studentDBUtil.updateStudent(attr, val, email);
		
		if(attr.equals("name")) {
			session.setAttribute("student_name", val);
		}
		else if(attr.equals("bio")) {
			session.setAttribute("student_bio", val);
		}
		else if(attr.equals("aoi")){
			session.setAttribute("student_aoi", val);
		}
		
		requestDispatcher = request.getRequestDispatcher("/profile.jsp");
		requestDispatcher.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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
