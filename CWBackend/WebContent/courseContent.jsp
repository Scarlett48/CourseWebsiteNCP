<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Playing Course Content</title>

	<link rel="icon" href="./img/titleicon.png" type="image/icon type">

	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>

<script>
	window.onload = function () {
    	var url = document.location.href,
        	params = url.split('?')[1].split('&'),
        	data = {}, tmp;
    	console.log(data);
    	for (var i = 0, l = params.length; i < l; i++) {
        	tmp = params[i].split('=');
         	data[tmp[0]] = tmp[1];
    	}
    	console.log(data.link);
    	document.getElementById('videolink').src = data.link;
    	document.getElementById('videotitle').innerHTML = localStorage["video_title"];
    	document.getElementById('videodesc').innerHTML = localStorage["video_desc"];
    	
}
</script>

</head>
<body style="background-color: #181a1b; text-align: center;">
	<div class="topnav" id="myTopnav">
		<a class="navbar-brand" href="#" style="float: left">
			<img src="./img/logo.png" height="28" alt="PROGRESS">
		</a>
		<a href="LogoutServlet">Log Out</a>
		<a href="./profile.jsp">Profile</a>
		<a href="CoursesControllerServlet">Courses</a>
	</div>
	
	<br><br>
	<div style="color: white">
            <h3 id="videotitle"></h3>
    </div>
    
	<div class="videoframe">
		<iframe id="videolink" src="https://www.youtube.com/embed/UB1O30fR-EE" allowfullscreen width="60%" height="500" style="border:none;"></iframe>
    	<script src="" async defer></script>
	</div>
	<br>
	<div style="color: white">
		<h3>About this course</h3>
		<p id="videodesc">This course is for beginners. Does not have any prerequisites</p>
	</div>
	<br> <br>
	<h4 style="color: white">You can help us improve the courses by providing ratings for the course!</h4>
	<a href="./ratings.jsp" >
		<button type="button" class="btn btn-light">Rate Here!</button>
	</a>
	<br> <br>
</body>
</html>