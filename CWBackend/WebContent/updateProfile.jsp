<!DOCTYPE html>
<html>
<head>
	<title>Update Profile</title>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="./img/titleicon.png" type="image/icon type">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<style>
		body{
			background-color:#181a1b;
			color:white;
			text-align: center;
		}
		.center {
  			margin-left: auto;
  			margin-right: auto;
		}
		th, td{
			padding: 15px;
		}
		table{
			text-align: left; font-size: 20px
		}
	</style>
<body>
	<div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a>Log Out</a>
		<a href="./profile.jsp" class="active">Profile</a>
		<a href="./team.jsp">The Team</a>
		<a href="CoursesControllerServlet">Courses</a>
	</div>
	<br><br>
	<h3>What would you like to update?</h3>
	<br><br>
	<form action="StudentControllerServlet" method="GET" class="center">
		<input type="hidden" name="command" value="UPDATE_Student">
		<table class="center">
			<tr>
				<td>
					<select name="updateAttribute">
						<option value="name">Name</option>
						<option value="bio">Bio</option>
						<option value="area_of_interest">Area of Interest</option>
					</select>
				</td>
				<td>
					<input type="text" name="updateValue">
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Update Profile" class="btn btn-warning">
	</form>
	<br><br>

	<form action="StudentControllerServlet" method="GET" class="center">
		<input type="hidden" name="command" value="ChangePassword">
		<h3>Password Change</h3>
		<table class="center">
			<tr>
				<td>Old Password : </td>
				<td><input type="text" name="oldPass"></td>
			</tr>
			<tr>
				<td>New Password : </td>
				<td><input type="text" name="newPass"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Change Password" class="btn btn-warning">
	</form>
	<br>
</body>
</html>