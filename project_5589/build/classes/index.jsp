<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<title>Mobileshop.in</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
	#brand-option{
		background-color: white;
	}
</style>
</head>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href='index.jsp'>Mobileshop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Mobiles <span class="caret"></span></a>
        <ul class="dropdown-menu">

					<form action="DisplaySamsung" method="post">
						<li><input type="submit" value="samsung" name="brand"
							id="brand-option"/></li>
					</form>

				</ul>

      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href='loginform.jsp'><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
    </ul>
  </div>
</nav>
<center>
<body>

<%
session.setAttribute("customerid",null);
%>
<div class="container">
	<div class="row">
	<div class="col-sm-12">
	 <img src="homeimage.jpg" height="472" width="950" style="padding-left:0.1px;">
	</div>
	</div>
	</div>
	</center>
	
<div class="container">
<div>
<div align =left><h3>New Arrivals!</h3></div>
  <div class="row">
    <div class="col-sm-3">
      <img src="samsung.jpg" height="272" width="200">
    </div>
    <div class="col-sm-3">
      <img src="samsung.jpg" height="272" width="200">
    </div>
	<div class="col-sm-3">
      <img src="samsung.jpg"  height="272" width="200">
    </div>
	<div class="col-sm-3">
     <img src="samsung.jpg"  height="272" width="200">
    </div>
	</div></div><br>

</body>
</html>