<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Home</title>
	<link rel="icon" href="./img/titleicon.png" type="image/icon type">

	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>

	<!-- <script>
		function myFunction() {
		  var x = document.getElementById("myTopnav");
		  if (x.className === "topnav") {
		    x.className += " responsive";
		  } else {
		    x.className = "topnav";
		  }
		}
	</script> -->
</head>
<body>
	<div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a href="./login.jsp">Login</a>
		<a href="./team.jsp">The Team</a>
		<a href="CoursesControllerServlet">Courses</a>
  		<a href="./index.jsp" class="active">About Us</a>
  		<!-- <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    		<i class="fa fa-bars"></i>
  		</a> -->
	</div>

	<div class="bgimg-1">
  		<div class="caption">
  			<span class="border">
  				Welcome to PROGRESS!
  			</span>
  		</div>
	</div>

    <div class = 'abtus'>
	  <h3 style="text-align:center;">ABOUT US</h3>
	  <p>Progress! The right place to hone your skills. We provide free online courses for everybody. A good education is one of the most important things an individual can pursue. It helps a person take a better and informed decision with the use of their knowledge. So, we are here to provide all those for free. Free education is important because it guarantees every student in a country some level of education. This means that each student has an equal opportunity to access this level of education on the same scale.</p>
	</div>


	<div class="bgimg-2">
	  <div class="caption">
	  <!-- <span class="border" style="background-color:transparent;font-size:25px;color: #f7f7f7;"></span> -->
	  </div>
	</div>

	<div style="position:relative;">
	  <div style="color:#ddd;background-color:#282E34;text-align:center;padding:50px 80px;text-align: center;">
	  <p>You can access the list of all courses available through the <a href="courses.jsp"> COURSES</a>.</p>
	  <p>Wanna contact us? Wanna know about us? Go to the <a href="./team.jsp">THE TEAM</a>!</p>
	  <p>You can create an account and track your courses through that.</p>
	  </div>
	</div>
</body>
</html>
