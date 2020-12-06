<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
  background-color:#181a1b;
  color:white;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 20%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #f3cb76;
  color: black;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
</style>

<link rel="icon" href="./img/titleicon.png" type="image/icon type">

	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,900;1,300;1,500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,900;1,400;1,900&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body style="background-color:#181a1b;">
    <div class="topnav" id="myTopnav">
        <a class="navbar-brand" href="#" style="float: left">
          <img src="./img/logo.png" height="28" alt="PROGRESS">
        </a>
        <a href="./profile.jsp">Profile</a>
        <a href="./team.jsp"  class="active">The Team</a>
        <a href="CoursesControllerServlet">Courses</a>
          <a href="./index.jsp">About Us</a>
        </div>
<div class="about-section">
  <h1>Our team</h1>
</div>
<div class="row">
  <div class="column">
    <div class="card">
      <img src="./img/prasanna.jpg" alt="Prasanna" style="width:100%">
      <div class="container">
        <h2>Prasanna</h2>
        <p>CB.EN.U4CSE17249</p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="./img/sai.jpg" alt="Priya" style="width:100%">
      <div class="container">
        <h2>Sai Priya</h2>
        <p>CB.EN.U4CSE17250</p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <img src="./img/hemanth.jpg" alt="Hemanth" style="width:100%">
      <div class="container">
        <h2>Hemanth</h2>
        <p>CB.EN.U4CSE17222</p>
      </div>
    </div>
  </div>

    <div class="column">
    <div class="card">
      <img src="./img/naidu.jpg" alt="Naidu" style="width:100%">
      <div class="container">
        <h2>Sai Naidu</h2>
        <p>CB.EN.U4CSE71232</p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="./img/nihal.jpg" alt="Nihal" style="width:100%">
      <div class="container">
        <h2>Sk Nihal</h2>
        <p>CB.EN.U4CSE71253</p>
      </div>
    </div>
  </div>
</div>

</body>
</html>
