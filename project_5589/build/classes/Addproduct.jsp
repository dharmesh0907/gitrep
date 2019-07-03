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
      <a class="navbar-brand" href='adminpage.jsp'>Mobileshop</a>
    </div>
   
      </li>
    </ul>
    
  
  <ul class="nav navbar-nav navbar-right">
			
			<li>
				<form action="logO23ut" method="post">
					<div class="mystyle">
						<input type="submit" value="logout" id="brand-option" />
					</div>
				</form>
			</li>
		</ul>
		</div>
</nav>

<%
if(request.getParameter("dropdown").equals("samsung")) {
session.setAttribute("brand",request.getParameter("dropdown"));
%>
<center>
<form method="post" action="AddSamsung" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Brand</td>
				<td>
				<select name="dropdown">
  <option value="samsung">samsung</option>
                </select>
				</td>
			</tr>

			<tr><td>model</td>
			<td><input type="text" name="model"></td>
			</tr>
			<tr>
				<td>stock</td>
				<td><input type="number" name="stock"></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<td>camera</td>
				<td><input type="number" name="camera"></td>
			</tr>
			<tr>
				<td>expandable memory</td>
				<td><input type="number" name="expandablememory"></td>
			</tr>
			<tr>
			<td>image</td>
			<td><input type="file" name="myimg"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
			</table>
			</form></center><%}else{ 
			session.setAttribute("brand",request.getParameter("dropdown"));%>
			<center>
		<form method="post" action="AddProduct" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Brand</td>
				<td>
				<select name="dropdown">
  <option value="mi">mi</option>
                </select>
				</td>
			</tr>
			
			
			<tr><td>model</td>
			<td><input type="text" name="model"></td>
			</tr>
			<tr>
				<td>stock</td>
				<td><input type="number" name="stock"></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<td>frontcamera</td>
				<td><input type="number" name="fcamera"></td>
			</tr>
			<tr>
				<td>rearcamera</td>
				<td><input type="number" name="rcamera"></td>
			</tr>
			<tr>
			<td>image</td>
			<td><input type="file" name="myimg"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
			</table>
			</form></center>	
			<%} 
			}%>
</body>
</html>