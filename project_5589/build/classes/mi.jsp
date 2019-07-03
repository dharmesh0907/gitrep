<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobileshop.in</title>
<style>
.column {
  box-shadow: 0 4px 20px 0 rgba(0, 10, 0, 0.3);
  margin-bottom: 30px;
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
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
      <li><a href='registerationform.jsp'><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href='loginform.jsp'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>



<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<%
Blob image=null;
Connection con = null;
byte[ ] imgData =null;
Statement stmt = null;
ResultSet rs = null;

try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","dharmesh98");
stmt = con.createStatement();
rs = stmt.executeQuery("select * from mi where productid>1");


while (rs.next()) {

%>

<div class="column">
      <img src="imagedisplay.jsp?imgid=<%=rs.getInt(1)%>brand=<%=rs.getString(2)%>" width="200" height="400"></a>
      <br>Product Name:
      <td>mi</td>   <td><%=rs.getString("model") %>
      <br>Rs.
      <tr><td><%=rs.getInt("price")%></td></tr><br>Quantity :
      <tr><td><%=rs.getInt("stock")%></td></tr>
      <p><a><button>Add to Cart</button></a></p>
      </div>
      
      
<%
}


rs.close();
stmt.close();
con.close();
} catch (Exception e) {
out.println( e.getMessage());
return;
} 

%>
</body></html>