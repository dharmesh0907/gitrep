package com.aspire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.aspire.BO.AdminService;
import com.aspire.DAO.AdminDAO;
import com.aspire.products.Mi;
import com.aspire.products.Samsung;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddSamsung")
@MultipartConfig(maxFileSize=67123456)
public class AddSamsung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSamsung() {
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
		 HttpSession session = request.getSession(true);
		
			Samsung samsung=new Samsung();
			samsung.setBrand((String)session.getAttribute("brand"));
			samsung.setModel(request.getParameter("model"));
			samsung.setStock(Integer.parseInt(request.getParameter("stock")));
			samsung.setPrice(request.getParameter("price"));
		    samsung.setCamera(Integer.parseInt(request.getParameter("camera")));
		    samsung.setExpandablememory(Integer.parseInt(request.getParameter("expandablememory")));
		    Part part=request.getPart("myimg");
			if(AdminService.samsungBO(samsung, part));
		    response.sendRedirect("adminpage.jsp");
	     }
			
	}	

