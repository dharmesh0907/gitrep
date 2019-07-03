package com.aspire.BO;

import java.util.List;

import com.aspire.DAO.UserDAO;

import com.aspire.bean.UserBean;
import com.aspire.products.Samsung;

public class UserService {
	public static int login(UserBean login)
	{
		
		return UserDAO.checkLogin(login.getUsername(),login.getPassword());
	}
	public static void Register(UserBean userbean)
	{
		UserDAO.registerDetails(userbean);
	}
	public static List<Samsung> showSamsung() 
	{
		//System.out.println(UserDao.DisplaySamsung());
		return UserDAO.DisplaySamsung();
	}
	public static void addCart(int customerid,int productid)
	{
		UserDAO.addToCart(customerid,productid);
	}
	public static List<Samsung>showCart(int customerid)
	{
		return UserDAO.customerCart(customerid);
	}
	public static void removeCart(int customerid,int productid)
	{
		UserDAO.deleteCart(customerid,productid);
	}
	public static boolean checkCart(int customerid,int productid)
	{
		return UserDAO.checkCart(customerid,productid);
	}
}
