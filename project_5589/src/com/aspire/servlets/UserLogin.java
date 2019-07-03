package com.aspire.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.aspire.BO.UserService;
import com.aspire.DAO.UserDAO;

import com.aspire.bean.UserBean;


@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		UserBean login=new UserBean();
		
		
		login.setUsername(request.getParameter("uname"));
	    login.setPassword(request.getParameter("upassword"));
	    HttpSession session = request.getSession();	
	   
        int cid=UserService.login(login);
	     if (cid!=0) 
		 {
		    
		       session.setAttribute("username",login.getUsername());
		       session.setAttribute("customerid",cid); 
		       response.sendRedirect("customer.jsp");     		
		 }
	    else if((login.getUsername().equals("admin"))&&(login.getPassword().equals("admin123")))
	    {	
	    	  session.setAttribute("username","admin");
		    response.sendRedirect("adminpage.jsp");
		    session.setAttribute("customerid",1);
	    }
		else
		{
        response.sendRedirect("invaliduser.jsp");			
		}

}


}

