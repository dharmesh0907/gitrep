package com.aspire.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.BO.AdminService;
import com.aspire.BO.UserService;
import com.aspire.products.Samsung;

/**
 * Servlet implementation class showCart
 */
@WebServlet("/showCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
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
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("customerid")==null) {
			response.sendRedirect("index.jsp");
		}
		else
		{
		List<Samsung> list=new ArrayList<Samsung> ();
		int customerid=(int)session.getAttribute("customerid");
		   list=UserService.showCart(customerid);
		   request.setAttribute("samobj", list);
		   RequestDispatcher requestdispatcher=request.getRequestDispatcher("Cart.jsp");
		   requestdispatcher.forward(request,response);
	}
	}

}
