<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"  %>

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
<body style="background-color: #181a1b; text-align: center;">
	<div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a href="./profile.jsp">Profile</a>
		<a href="./team.jsp">The Team</a>
		<a href="CoursesControllerServlet">Courses</a>
  		<a href="./index.jsp">About Us</a>
    </div>
    <br>
    <div style="color: white">
            <h3>Courses Offered</h3>
    </div>
    
    <div class="main">    
        <ul class="cards">
        	<%
        	List<String> titles = (List<String>) request.getAttribute("titles");
        	List<String> descriptions = (List<String>) request.getAttribute("descriptions");
        	
        	for(int i=0; i<descriptions.size(); i++){
           		out.println("<li class=\"cards_item\">");
        		out.println("	<div class=\"card\">");
        		out.println("		<div onclick=\"window.open('courseContent.jsp','mywindow');\" class=\"card_content\">");
        		out.println("			<h2 class=\"card_title\">"+ titles.get(i) +"</h2>");
        		out.println("			<p class=\"card_text\">"+ descriptions.get(i) + "</p>");
        		out.println("			<button class=\"btn card_btn\">Go to Course</button>");
        		out.println("		</div>");
        		out.println("	</div>");
        		out.println("</li>");
        	}
        	%>
        </ul>
    </div>
</body>
</html>