<!DOCTYPE html>
<html>
<head>
	<title>Add Course</title>
	<link rel="icon" href="./img/titleicon.png" type="image/icon type">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">

	function validateForm() {
  var title = document.forms["courseForm"]["ctitle"].value;
  if (title == "") {
    alert("The Title of the course must be filled!");
    return false;
  }

  var link = document.forms["courseForm"]["link"].value;
  if (link == "") {
    alert("The link to the course must be given!");
    return false;
  }

  regexp =  /^(?:(?:https?|ftp):\/\/)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/\S*)?$/; 

    if (! regexp.test(link)) 
    { 
      alert("Not a proper URL!")
      return false; 
    } 

  var desc = document.forms["courseForm"]["desc"].value;
  if (desc == "") {
    alert("The description of the course must be filled!");
    return false;
  }

  alert("Your course has been added successfully!!!")
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
	<h2>You can add courses here!</h2>
	<br>
	<form name="courseForm" action="CoursesControllerServlet" method="GET">
		<input type="hidden" name="command" value="AddCourse">
		<label>Enter your COURSE TITLE</label><br>
		<input type="text" name="ctitle"><br><br>
		<label>Provide the link to your course here</label><br>
		<ol>
			<li>Upload your course video to your YouTube Account
			<li>Go to the video and click on Share
			<li>Click on EMBED option
			<li>Copy the link displayed within 'src' attribute and paste it here
		</ol>
		<input type="text" name="link"><br><br>
		<label>Describe your course</label><br>
		<textarea name="desc" rows="4" cols="40"></textarea><br><br>
		<label>Do you like to include multiple choice questions(MCQs) to asses the students?</label><br>
		<input type="radio" name="assignment" value="yes">
		<label for="yes">Yes</label><br>
		<input type="radio" name="assignment" value="no">
		<label for="no">No</label><br>

		<input type="submit" value="Add Course" class="btn btn-warning" onclick="validateForm()">
	</form>
	<br>
	<h6>Please note that all courses will be published only after moderator's approval</h6>
	<br><br>
</body>
</html>