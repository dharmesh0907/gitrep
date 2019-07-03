<!DOCTYPE html>
<html>
<%
if(session.getAttribute("customerid")==null)
{
	response.sendRedirect("index.jsp");
	}else
	{
%>
<head>
<meta charset="ISO-8859-1">
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

<center>
<form method="post" action="Addproduct.jsp">
<select  name="dropdown">
  <option value="samsung">samsung</option>
  <option value="mi">mi</option>
                </select>
                <button>Add</button>
</form>
</center>

</body>
<%} %>
</html>