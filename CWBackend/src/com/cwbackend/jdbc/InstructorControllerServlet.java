package com.cwbackend.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/InstructorControllerServlet")
public class InstructorControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InstructorDBUtil instructorDBUtil;
	RequestDispatcher requestDispatcher;
	
	@Resource(name="jdbc/cw_backend_db")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student DButil and pass in the connection pool / datasource
		try {
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
				
			case "UPDATE_Instructor":
				updateInstructor(request, response);
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
		
		List<Instructor> ins = instructorDBUtil.getInstructor(email);
		if (ins.get(0).getPassword().equals(oldPassword)) {
			instructorDBUtil.updateInstructor("password", newPassword, email);
			
			updateInstructor(request, response);
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password has been successfully changed!');");
			out.println("location='instructorProfile.jsp';");
			out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Old password does not match!');");
			out.println("location='instructorUpdateProfile.jsp';");
			out.println("</script>");
		}
	}

	private void updateInstructor(HttpServletRequest request, HttpServletResponse response) {
		try {
			// read the parameters required for updation
			String attr = request.getParameter("updateAttribute");
			String val = request.getParameter("updateValue");
			
			System.out.println(attr + val);
			
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			
			instructorDBUtil.updateInstructor(attr, val, email);
			
			if(attr.equals("name")) {
				session.setAttribute("instructor_name", val);
			}
			else if(attr.equals("about")) {
				session.setAttribute("instructor_about", val);
			}
			else if(attr.equals("aoe")){
				session.setAttribute("instructor_aoe", val);
			}
			
			requestDispatcher = request.getRequestDispatcher("/instructorProfile.jsp");
			requestDispatcher.forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	private void checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read the parameters to know email and password
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//check if user exists in database
		if(instructorDBUtil.checkInstructor(email)) {
			List<Instructor> ins = instructorDBUtil.getInstructor(email);
			if(ins.get(0).getPassword().equals(password)) {
				session.setAttribute("email", email);
				session.setAttribute("instructor_name", ins.get(0).getName());
				session.setAttribute("instructor_about", ins.get(0).getAbout());
				session.setAttribute("instructor_aoe", ins.get(0).getArea_of_expertise());
				session.setAttribute("instructor_ratings", ins.get(0).getRatings());
				
				requestDispatcher = request.getRequestDispatcher("/instructorProfile.jsp");
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

}
