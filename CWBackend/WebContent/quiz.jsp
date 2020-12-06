<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.cwbackend.jdbc.Question"  %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Available Courses</title>

	<link rel="icon" href="./img/titleicon.png" type="image/icon type">

	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body style="background-color: #181a1b; color: white;">
	<div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a href="LogoutServlet">Log Out</a>
		<a href="./profile.jsp">Profile</a>
		<a href="CoursesControllerServlet">Courses</a>
    </div>
    <br>
    <div style="color: white">
            <h3 style="text-align: center;">Quiz</h3>
    </div>
    <br>
    <ol name="ques">
    <% 
    	List<Question> questions= (List<Question>) request.getAttribute("questions");
		
    	for(int i=0; i<questions.size(); i++){
    		String op[] = questions.get(i).getOptions().split(";");
    		out.println("<li>"+ questions.get(i).getQuestion()+"</li> ");
    		out.println("<input type='radio' name=ques'"+(i+1)+"' value='option1'>"+op[0]+"<br>");
    		out.println("<input type='radio' name=ques'"+(i+1)+"' value='option2'>"+op[1]+"<br>");
    		out.println("<input type='radio' name=ques'"+(i+1)+"' value='option3'>"+op[2]+"<br>");
    		out.println("<input type='radio' name=ques'"+(i+1)+"' value='option4'>"+op[3]+"<br><br>");
    	}

    %>	
    </ol>
</body>
</html>