<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("customerid")==null)
	response.sendRedirect("index.jsp");
%>
<center>
<b>Products</b>
<table border="1px" >
  <tr>
   <b ><td>Product_Id</td>
    <td><center> brand</center></td>
    <td><center>model</center></td></b>
    <td><center>stock</center></td></b>
    <td><center>price</center></td></b>
    <td><center>camera</center></td></b>
    <td><center>Expandable memory</center></td></b>
  </tr>

<c:forEach items="${samsungobj}" var="list">
<tr>
    <td>${list.productid}</td>
    <td>${list.brand}</td>
     <td>${list.model}</td>
    <td>${list.stock}</td>
    <td>${list.price}</td>
    <td>${list.camera}</td>
    <td>${list.expandablememory}</td>
</tr>
</c:forEach>
</table></center>

</body>
<%} %>
</html>