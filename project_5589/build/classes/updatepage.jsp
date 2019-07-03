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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
.but{
 margin-top: 10px;
}
</style>
<style>
.mystyle {
	margin-top: 12px;
}
</style>
</head>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href='adminpage.jsp'>Mobileshop</a>
    </div>
   
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
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("customerid")==null)
	response.sendRedirect("index.jsp");
%>
<center>

<form name="update" action="UpdateProduct" method="post" onsubmit="return validateform()">
<table>
<tr><td>Select Product :</td>
<td><select  name="dropdown">
  <option value="samsung">samsung</option>
  <option value="mi">mi</option>
                </select></td></tr> <br><br>               
 <tr><td>Productid:</td>               
       <td><input type="number" name="pdid"></td></tr>
          <br><br>       
 <tr><td>price:</td>
 <td><input type="number" name="price" ></td></tr><br><br></table>
  <div class="but"><center><input type="submit" value="update"></center></div>
</form>
</center>

</body>
<% }%><script>
function validateform(){  
var pdid=document.update.pdid.value;  
var price=document.update.price.value;

if ( pdid==""||price==""){  
  alert("fields can't be blank");  
  return false;  
}
return true;
}
</script>

</html>