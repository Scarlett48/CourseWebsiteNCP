package com.cwbackend.jdbc;

import java.io.IOException;
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
			RequestDispatcher requestDispatcher;
			
			//if the command is missing just display all the courses
			if(theCommand == null) {
				List<String> titles = coursesDBUtil.getCoursesTitle();
				List<String> descriptions = coursesDBUtil.getCoursesDescription();
				request.setAttribute("titles", titles);
				request.setAttribute("descriptions", descriptions);
				requestDispatcher = request.getRequestDispatcher("/courses.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
			
			//route to appropriate method
//			switch(theCommand) {
//			
//			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

}
