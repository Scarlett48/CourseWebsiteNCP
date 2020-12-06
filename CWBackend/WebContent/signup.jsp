<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Register</title>
	<link rel="icon" href="./img/titleicon.png" type="image/icon type">

	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
	
	<script language="JavaScript">
		    function name_check() {
            var name;
            name=document.forms["register"]["name"].value;
            name=name.trim();
            if(name)
            {
                var code, i, len;
                for (i = 0, len = name.length; i < len; i++) {
                    code = name.charCodeAt(i);
                    if (!(code > 64 && code < 91) &&
                        !(code > 96 && code < 123) && !(code==32)) {
                        alert("Username should have only alphabet");
                    return false;
                    }
                }
                return true;
            }
            else{
                alert("Name cannot be empty");
                return false;
            }
        }

		function pwd_match_check() {
			var pwd;
			var re_pwd;
			pwd = document.forms["register"]["password"].value;
			re_pwd = document.forms["register"]["re_password"].value;
			if (pwd == re_pwd)
				return true;
			else
			{
				alert("Password didn't match");
				return false;
			}
		}
		
		function ValidateEmail() {
			var inputText = document.forms["register"]["email"].value;
			var mailformat = /^w+([.-]?w+)*@w+([.-]?w+)*(.w{2,3})+$/;
			if(mailformat.match(inputText))
			return true;
			else
			{
			alert("You have entered an invalid email address!"); 
			return false;
			}
		}

		function strength_check() {
			var pwd_pattern=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
			var pwd;
			pwd = document.forms["register"]["password"].value;
			if(pwd_pattern.test(pwd)) 
			{
			return true;
			}
			else
			{ 
			alert('Password should be 8-15 characters long with atleast one lower case letter, upper-case letter, number and special characters.')
			return false;
			}
		}

		function form_check() {
			if (name_check() && ValidateEmail() && strength_check() && pwd_match_check())
			{	
				alert("Registration successful!!");
				return true;
			}
			else
			{
				alert("Please enter valid inputs");
				return false;
			}
		}
	</script>
</head>

<body style="text-align: center;">
	<div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a href="./register.jsp" class="active">Register</a>
		<a href="./team.jsp">The Team</a>
		<!-- <a href="CoursesControllerServlet">Courses</a> -->
  		<a href="./index.jsp">About Us</a>
	</div>

	<div class="bgimg-2" min-height=400px>
        <section class="signup">
        
        <div class="container">
        <div class="signup-content">
        
        <form name="register" action="StudentControllerServlet" method="GET" id="signup-form" class="signup-form">
        
        <input type="hidden" name="command" id="command" value="ADD_TO_DB">

		<h2 class="form-title">Create account</h2>
		<h6>Register as</h6>
		<input type="radio" id="student" name="role" value="student">
		<label for="student">Student</label>
		<br>
		<input type="radio" id="instructor" name="role" value="instructor">
		<label for="instructor">Instructor</label><br>
		<div class="form-group">
		<input type="text" class="form-input" name="name" id="name" placeholder="Your Name" onchange="name_check()" required/>
		</div>
		<div class="form-group">
		<input type="email" class="form-input" name="email" id="email" placeholder="Your Email" required/>
		</div>
		
		<div class="form-group">
		<input type="password" class="form-input" name="password" id="password" placeholder="Password" onchange="strength_check()" required/>
		<!--<span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>-->
		</div>
		<div class="form-group">
		<input type="password" class="form-input" name="re_password" id="re_password" placeholder="Repeat your password" onchange="pwd_match_check()" required/>
		</div>
        <div class="form-group">
        <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"  onclick="form_check()"/>
        </div>
        </form>
        <p>
        Have already an account ? <a href="./login.jsp">Login here</a>
        </p>
        </div>
        </div>
        </section>
    </div>
</div>
</body>
</html>