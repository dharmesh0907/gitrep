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
import com.aspire.bean.UserBean;
import com.aspire.products.Samsung;

/**
 * Servlet implementation class DisplaySamsung
 */
@WebServlet("/DisplaySamsung")
public class DisplaySamsung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySamsung() {
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
		
		
		List<Samsung> list=new ArrayList<Samsung>(); 
		
		   list=UserService.showSamsung();
		  
		   request.setAttribute("Dsamsung", list);
			   RequestDispatcher requestdispatcher=request.getRequestDispatcher("samsung.jsp");
			   requestdispatcher.forward(request,response); 
		   
		
	}

}
