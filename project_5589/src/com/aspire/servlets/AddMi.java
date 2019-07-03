package com.aspire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aspire.BO.AdminService;
import com.aspire.products.Mi;

/**
 * Servlet implementation class AddMi
 */
@WebServlet("/AddMi")
public class AddMi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMi() {
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
		Mi mi=new Mi();
		mi.setBrand((String)session.getAttribute("brand"));
		mi.setModel(request.getParameter("model"));
		mi.setStock(Integer.parseInt(request.getParameter("stock")));
		mi.setPrice(request.getParameter("price"));
	    mi.setFrontcamera(Integer.parseInt(request.getParameter("fcamera")));
	    mi.setRearcamera(Integer.parseInt(request.getParameter("rcamera")));
	    Part part=request.getPart("myimg");
	if(AdminService.miBO(mi, part))
	    response.sendRedirect("adminpage.jsp");
	}

}
