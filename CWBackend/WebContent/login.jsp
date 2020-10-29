<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title id="login">Login</title>
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
		<a href="./login.jsp"  class="active">Login</a>
		<a href="./team.jsp">The Team</a>
		<a href="./courses.jsp">Courses</a>
  		<a href="./index.html">About Us</a>
	</div>

	<div class="bgimg-login">
        <section class="signup">
        
        <div class="container">
        <div class="signup-content">
        <form method="POST" id="login-form" class="login-form">
		<h2 class="form-title">Login here</h2>
		<div class="form-group">
		<input type="email" class="form-input" name="email" id="email" placeholder="Email ID" />
		</div>
		<div class="form-group">
		<input type="text" class="form-input" name="password" id="password" placeholder="Password" />
        <!--<span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>-->
        </div>
        <div class="form-group">
        <input type="submit" name="submit" id="submit" class="form-submit" value="Login" />
        </div>
        </form>
        <p>
        New user? <a href="./signup.jsp">Register here</a>
        </p>
        </div>
        </div>
		</section>
    </div>
</div>
</body>
</html>
