package com.aspire.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.BO.UserService;
import com.aspire.products.Samsung;

/**
 * Servlet implementation class Addtocart
 */
@WebServlet("/Addtocart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession(true);
		int productid=Integer.parseInt(request.getParameter("productid"));
		
		if(session.getAttribute("customerid")!=null) {
		if(UserService.checkCart((int)session.getAttribute("customerid"),productid)) 
		{
			
			response.sendRedirect("incart.jsp");   
		}
		else
		{
		UserService.addCart( (int)session.getAttribute("customerid") , productid);
		response.sendRedirect("customer.jsp");
		}
		}
		else
		{
			response.sendRedirect("loginform.jsp");
		}
	}


	}


