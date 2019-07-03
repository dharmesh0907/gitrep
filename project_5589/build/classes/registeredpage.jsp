<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
     
            <li>
            <input type="submit" value="samsung" name="brand" id="brand-option" />
            </li>
             
             </form>
          
        </ul>
      </li>
    </ul>
  </div>
</nav>
<body style="background-color:#bab7b6;">
<center>
<%
out.println("welcome  " +(String)session.getAttribute("username"));
%>
</br>
Now <button onClick="window.location.href='loginform.jsp'">login</button>
<center>
</body>
</html>