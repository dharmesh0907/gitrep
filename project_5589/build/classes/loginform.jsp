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
<style>

</style>
</head>
<body  style="background-color:#bab7b6;">
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
    <ul class="nav navbar-nav navbar-right">
    
      <li><a href='registerationform.jsp'><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
    </ul>
  </div>
</nav>
<center>
<h2>Login  Form</h2>
	<form name="loginform1" align='center' method="post" action="login" onsubmit="return validateform()">
		<table>
			<tr>
				<td>username</td>
				<td><input type="text" name="uname"></td><br><br>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="upassword"></td>
			</tr>
			
				<tr><td><input type="submit" value="login"></td></tr>  
			
			</table>
			</form>
			</center>
</body>
<script>
function validateform(){  
var name=document.loginform.uname.value;  
var password=document.loginform.upassword.value;

if ( name==""||password==""){  
  alert("fields can't be blank");  
  return false;  
}
return true;

}
</script>



</html>