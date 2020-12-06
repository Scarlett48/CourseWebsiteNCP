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
import javax.sql.DataSource;

@WebServlet("/CoursesControllerServlet")
public class CoursesControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CoursesDBUtil coursesDBUtil;
	RequestDispatcher requestDispatcher;
	
	@Resource(name="jdbc/cw_backend_db")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our DButil and pass in the connection pool / data source
		try {
			coursesDBUtil = new CoursesDBUtil(dataSource);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the value of command parameter from the html/jsp page
			String theCommand = request.getParameter("command");
			
			//if the command is missing just display all the courses
			if(theCommand == null) {
				List<String> titles = coursesDBUtil.getCoursesTitle();
				List<String> links = coursesDBUtil.getCoursesLink();
				List<String> descriptions = coursesDBUtil.getCoursesDescription();
				request.setAttribute("titles", titles);
				request.setAttribute("links", links);
				request.setAttribute("descriptions", descriptions);
				requestDispatcher = request.getRequestDispatcher("/courses.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
			
			//route to appropriate method
			switch(theCommand) {
			case "AddCourse":
				addCourse(request,response);
				break;
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void addCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("ctitle");
		String link = request.getParameter("link");
		String desc = request.getParameter("desc");
		String assignment = request.getParameter("assignment");
		
		//create Courses object to insert into database
		Courses theCourse = new Courses(title, link, desc, assignment);
		coursesDBUtil.insertCourse(theCourse);
		
		PrintWriter out = response.getWriter();
		//route back to courses page
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Successfully added the course!');");
		out.println("location='courses.jsp';");
		out.println("</script>");
		
	}

}
