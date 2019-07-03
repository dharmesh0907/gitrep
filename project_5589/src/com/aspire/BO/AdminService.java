package com.aspire.BO;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aspire.DAO.AdminDAO;
import com.aspire.bean.UserBean;
import com.aspire.products.Mi;
import com.aspire.products.Samsung;

public class AdminService {

	public static boolean samsungBO(Samsung samsung,Part part)
	{
		AdminDAO.addSamsung(samsung, part);
		return true;
	}
	public static boolean miBO(Mi mi,Part part)
	{
		AdminDAO.addMi(mi, part);
		return true;
	}
	public static List<UserBean> customerDetails(){ 
	return AdminDAO.showCustomer();
	}
	public static List<Samsung> samsungDetails (){ 
		return AdminDAO.showSamsung();
		}
	public static void deleteProducts(String brand,int productid)
	{
		AdminDAO.deleteProducts(brand,productid);
		AdminDAO.deleteCart(productid);
	}
	public static void updateProducts(String brand,int productid,String price)
	{
		AdminDAO.updateProducts(brand,productid,price);
		AdminDAO.updateCart(brand,productid,price);
	}
	
	
	
}
