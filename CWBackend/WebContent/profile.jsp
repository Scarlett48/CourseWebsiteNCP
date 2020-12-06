<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="./img/titleicon.png" type="image/icon type">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
	
	<style>
		body{
			background-color:#181a1b;
			color:white;
			align-content: center;
			align-items: center;
			align-self: center;
			text-align: center;
		}
		.center {
  			margin-left: auto;
  			margin-right: auto;
		}
		th, td{
			padding: 15px;
		}
	</style>
</head>
<body>
    <div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a href="LogoutServlet">Log Out</a>
		<a href="./profile.jsp" class="active">Profile</a>
		<a href="CoursesControllerServlet">Courses</a>
	</div>

	<br>
  	<h3>My Profile</h3>
  	<br>
	<img class="image" height="142" width="142" src="./img/placeholder_pro_img.jpg" alt="Profile">
	  			
	<br><br>
	<table class="center" style="text-align: left; font-size: 20px">
		<tr>
			<th>Name : </th>
		  	<% out.println("<th>"+ session.getAttribute("student_name") +"</th>"); %>
		</tr>
		<tr>
			<th>Email : </th>
			<% out.println("<th>"+ session.getAttribute("email") +"</th>"); %>
		</tr>
		<tr>
			<th>Bio : </th>
			<% out.println("<th>"+ session.getAttribute("student_bio") +"</th>"); %>
		</tr>
		<tr>
			<th>Area of Interest : </th>
			<% out.println("<th>"+ session.getAttribute("student_aoi") +"</th>"); %>
		</tr>
	</table>
	<br>
	<form action="updateProfile.jsp">	
		<input type="submit" value="Update Profile" class="btn btn-warning">
	</form>
	
	<br><br>
  	
</body>
</html>