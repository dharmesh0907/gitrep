<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobileshop.in</title>
<style>
#brand-option {
	background-color: white;
}

.column {
	box-shadow: 0 4px 20px 0 rgba(0, 10, 0, 0.3);
	margin-bottom: 30px;
	max-width: 300px;
	margin: auto;
	text-align: center;
	font-family: arial;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.mystyle {
	margin-top: 12px;
}
</style>
</head>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<%if(session.getAttribute("username")!=null){%>
      <a class="navbar-brand" href='customer.jsp'>Mobileshop</a>
      <% }
      else{
    	 %>
    	 <a class="navbar-brand" href='index.jsp'>Mobileshop</a>
     <%  }
      %>
	</div>
	<ul class="nav navbar-nav">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">Mobiles <span class="caret"></span></a>
			<ul class="dropdown-menu">

				<form action="DisplaySamsung" method="post">
					<li><input type="submit" value="samsung" name="brand"
						id="brand-option" /></li>
				</form>

			</ul></li>
	</ul>
<ul class="nav navbar-nav navbar-right">
			
			<li>
				<form action="logOut" method="post">
					<div class="mystyle">
						<input type="submit" value="logout" id="brand-option" />
					</div>
				</form>
			</li>
		</ul>
	</div>	
</nav>

<body>
<center><h2>Item already in cart!</h2><br>
<form action="DisplaySamsung" method="post">
						<li><input type="submit" value="Back to cart" name="brand"
							id="brand-option"/></li>
					</form></center>

</body>

</html>