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
	<link rel="stylesheet" href="homestyle.css">
</head>
<body style="background-color:#bab7b6;">
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
<center><h1>Registeration form</h1>
<form name="regform"method="post" action="registeration"  onsubmit="return validateform()">
		<table>
			<tr>
				<td>username</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="uemail" pattern="[a-z0-9]{4,}+@[a-z]{3,}+.[a-z]{2,}"></td>
			</tr>
			<tr>
				<td>mobilenumber</td>
				<td><input type="number" name="umn"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="upassword"></td>
			</tr>
			<tr>
				<td>Re-enter password</td>
				<td><input type="password" name="rpassword"></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
			</tr>
			</table>
			</form></center>
			<script>  
function validateform(){  
var name=document.regform.uname.value;  
var fpassword=document.regform.upassword.value;
var lpassword=document.regform.rpassword.value;  
 var mobile=document.regform.umn.value;
 var email=document.regform.uemail.value;

if ( name==""||mobile==""||fpassword==""||lpassword==""||email==""){  
  alert("fields can't be blank");  
  return false;  
}
if(fpassword.length<4){  
  alert("Password must be at least 4 characters long.");  
  return false;  
  } 
if(fpassword!=lpassword){  
	  alert("please reenter password correctly");  
	  return false;  
	  } 
return true;
}


</script>  
			
			
			
</body>
</html>