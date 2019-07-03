package com.aspire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.aspire.BO.UserService;
import com.aspire.DAO.UserDAO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class registeration
 */
@WebServlet("/registeration")
public class UserRegister extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {

try
{	    
UserBean userBean = new UserBean();
userBean.setUsername(request.getParameter("uname"));
userBean.setPassword(request.getParameter("upassword"));
userBean.setEmail(request.getParameter("uemail"));
userBean.setMobilenumber(request.getParameter("umn"));
UserService.Register(userBean);
	    

HttpSession session = request.getSession(true);	    
session.setAttribute("username",userBean.getUsername()); 
response.sendRedirect("registeredpage.jsp");     		
}


catch (Throwable theException) 	    
{
System.out.println(theException); 
}
}
	
	}
