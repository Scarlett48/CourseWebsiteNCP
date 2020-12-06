<!DOCTYPE html>
<html>
<head>
	<title>Add Questions</title>
	<link rel="icon" href="./img/titleicon.png" type="image/icon type">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>

<script type="text/javascript">
	function validateForm(){
		if(document.forms["quesForm"]["question"].value=="" ||  document.forms["quesForm"]["option1"].value=="" || document.forms["quesForm"]["option2"].value=="" || document.forms["quesForm"]["option3"].value=="" || document.forms["quesForm"]["option4"].value==""){
			alert("Fill all the boxes!!");
			return false;
		}
		location = "CoursesControllerServlet";
	}

	function nextValidateForm(){
		if(document.forms["quesForm"]["question"].value=="" ||  document.forms["quesForm"]["option1"].value=="" || document.forms["quesForm"]["option2"].value=="" || document.forms["quesForm"]["option3"].value=="" || document.forms["quesForm"]["option4"].value==""){
			alert("Fill all the boxes!!");
			return false;
		}
		location = "./addQuestion.jsp";
	}
</script>

<body style="background-color:#181a1b ; text-align: center; color: white; list-style-position: inside;">

	<div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a href="LogoutServlet">Log Out</a>
		<a href="./instructorProfile.jsp">Profile</a>
		<a href="./addCourse.jsp" class="active">Add Courses</a>
		<a href="CoursesControllerServlet">Courses</a>

	</div>
	<br>
	<h2>You can add questions for your course here!</h2>
	<br>
	<form name="quesForm" action="CoursesControllerServlet" method="GET">
		<input type="hidden" name="command" value="AddNextQuestion">

		<label>Enter your question</label><br>
		<textarea name="question" rows="3" cols="65"></textarea><br><br>

		<label>Option1</label><br>
		<textarea name="option1" rows="1" cols="50"></textarea><br><br>

		<label>Option2</label><br>
		<textarea name="option2" rows="1" cols="50"></textarea><br><br>

		<label>Option3</label><br>
		<textarea name="option3" rows="1" cols="50"></textarea><br><br>

		<label>Option4</label><br>
		<textarea name="option4" rows="1" cols="50"></textarea><br><br>

		<label>Correct Option</label><br>
		<select name="correct_option">
			<option value="option1">Option 1</option>
			<option value="option2">Option 2</option>
			<option value="option3">Option 3</option>
			<option value="option4">Option 4</option>
		</select>
		<br><br>

		<input type="submit" value="Add Next Question" class="btn btn-warning">
	</form>
	<br><br>
</body>
</html>