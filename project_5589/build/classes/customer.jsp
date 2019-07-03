<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
if(session.getAttribute("customerid")==null)
{
	response.sendRedirect("index.jsp");
	}else
	{
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobileshop.in</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
#brand-option {
	background-color: white;
}
</style>
<style>
.mystyle {
	margin-top: 12px;
}
</style>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("customerid")==null)
	response.sendRedirect("index.jsp");
%>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href='customer.jsp'>Mobileshop</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Mobiles <span class="caret"></span></a>
				<ul class="dropdown-menu">

					<form action="DisplaySamsung" method="post">

						<li><input type="submit" value="samsung" name="brand"
							id="brand-option"/></li>

					</form>

				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<form action="showCart" method="post">
					<div class="mystyle">
						<input type="submit" value="Cart" id="brand-option" />
					</div>
				</form>
			</li>
			<li><a><%="Hi, " + (String) session.getAttribute("username")%></a></li>
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
	<center>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<img src="homeimage.jpg" height="472" width="950"
						style="padding-left: 0.1px;">
				</div>
			</div>
		</div>
	</center>
	<div class="container">
		<div>
			<div align=left>
				<h3>New Arrivals!</h3>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<img src="samsung.jpg" height="272" width="200">
				</div>
				<div class="col-sm-3">
					<img src="samsung.jpg" height="272" width="200">
				</div>
				<div class="col-sm-3">
					<img src="samsung.jpg" height="272" width="200">
				</div>
				<div class="col-sm-3">
					<img src="samsung.jpg" height="272" width="200">
				</div>
			</div>
		</div>
		<br>
</body>
<%} %>
</html>