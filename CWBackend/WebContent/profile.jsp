<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
</head>
<body style="background-color:#181a1b ; text-align: center;">
    <div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a>Logout</a>
		<a href="./profile.html" class="active">Profile</a>
		<a href="./team.html">The Team</a>
		<a href="./courses.html">Courses</a>
  		<a href="./index.html">About Us</a>
	</div>
	<style>
		*{
			box-sizing:border-box;
		}
		.nav{
			display:inline-block;
			float:right;
			position:absolute;
			top:40px;
			right:40px;
		}
		a{
			text-decoration:none;
			color:blue;
			padding-right:10px;
		}
		.body{
			position:absolute;
			top:8%;
			left:40%;
			padding:20px;
		}
		label,input{
			margin-bottom:10px;
		}
		body{
			background-color:#181a1b;
			color:white;
		}
	</style>

	
  	<div class="body">
  		<fieldset>
  				<legend>My Profile</legend>
	  			<img class="image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQP-i5liksKo3g85Qz90jpYieJ4J_YGy5S7JQ&usqp=CAU" alt="Profile">
	  			<form>
		  			<label for="profile">Upload your Image:</label><br>
		  			<input type="file" id="profile" name="profile"><br>
		  			<label for="fname">First Name:</label><br>
		  			<input type="text" id="fname" name="fname" value="Praveen"><br>
		  			<label for="lname">Last Name:</label><br>
		  			<input type="text" id="lname" name="lname" value="Thambe"><br>
		  			<label for="DOB">Date of Birth:</label><br>
		  			<input type="date" id="DOB" name="DOB" value="2000-01-01"><br>
		  			<label for="courses">Number of Courses Opted:</label><br>
		  			<input type="number" id="courses" name="courses" value=8><br>
	  		</form>
  		</fieldset>
  	</div>
</body>
</html>