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
			HttpSession session = request.getSession();
			
			//if the command is missing just display all the courses
			if(theCommand == null) {
				List<String> titles = coursesDBUtil.getCoursesTitle();
				List<String> links = coursesDBUtil.getCoursesLink();
				List<String> descriptions = coursesDBUtil.getCoursesDescription();
				List<Courses> courses = coursesDBUtil.getCourses();
				
				request.setAttribute("titles", titles);
				request.setAttribute("links", links);
				request.setAttribute("descriptions", descriptions);
				request.setAttribute("courses", courses);
				
				if(session.getAttribute("role")==null) {
					requestDispatcher = request.getRequestDispatcher("/aboutCourses.jsp");
					requestDispatcher.forward(request, response);
					return;
				}
				if(session.getAttribute("role").equals("student")) {
					requestDispatcher = request.getRequestDispatcher("/courses.jsp");
					requestDispatcher.forward(request, response);
					return;
				}
				else if(session.getAttribute("role").equals("instructor")) {
					requestDispatcher = request.getRequestDispatcher("/instructorCourses.jsp");
					requestDispatcher.forward(request, response);
					return;
				}
				else{
					requestDispatcher = request.getRequestDispatcher("/aboutCourses.jsp");
					requestDispatcher.forward(request, response);
					return;
				}
			}
			
			//route to appropriate method
			switch(theCommand) {
			case "AddCourse":
				addCourse(request,response);
				break;
				
			case "BeginQuiz":
				beginQuiz(request, response);
				break;
				
			case "AddNextQuestion":
				addNextQuestion(request, response);
				break;
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void beginQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Question> questions = coursesDBUtil.getQuestions(request.getParameter("ctitle"));
		request.setAttribute("questions", questions);
		
		requestDispatcher = request.getRequestDispatcher("/quiz.jsp");
		requestDispatcher.forward(request, response);
	}

	private void addNextQuestion(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		
		String title = (String) session.getAttribute("course_title");
		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String correct_option = request.getParameter("correct_option");
		
		//Create QUestion object to insert into database
		Question theQuestion = new Question(title, question, option1+";"+option2+";"+option3+";"+option4, correct_option);
		coursesDBUtil.insertQuestion(theQuestion);
		
		requestDispatcher = request.getRequestDispatcher("./addQuestion.jsp");
		requestDispatcher.forward(request, response);
	}

	private void addCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String title = request.getParameter("ctitle");
		String link = request.getParameter("link");
		String desc = request.getParameter("desc");
		String assignment = request.getParameter("assignment");
		PrintWriter out = response.getWriter();
		
		//check if the course title is unique
		if(coursesDBUtil.checkCourse(title)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('The Course Title has to be unique, try again!');");
			out.println("location='./addCourse.jsp';");
			out.println("</script>");
		}
		
		//create Courses object to insert into database
		Courses theCourse = new Courses(title, link, desc, assignment);
		coursesDBUtil.insertCourse(theCourse);
		
		if(assignment.equals("yes")) {
			session.setAttribute("course_title", title);
			requestDispatcher = request.getRequestDispatcher("/addQuestion.jsp");
			requestDispatcher.forward(request, response);
		}
		
		//route back to courses page
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Successfully added the course!');");
		out.println("location='CoursesControllerServlet';");
		out.println("</script>");
		
	}

}
