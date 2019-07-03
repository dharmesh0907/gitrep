package com.aspire.DAO;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import java.io.InputStream;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;


import com.aspire.bean.UserBean;
import com.aspire.connect.Connect;
import com.aspire.products.Samsung;

import java.sql.Connection;

public class UserDAO {
	
	Scanner sc = new Scanner(System.in);
	static Connection connection=null;
	static Statement statement=null;
	//static ResourceBundle resourceBundle = ResourceBundle.getBundle("sql");
	public static void registerDetails(UserBean userBean) {
		connection = Connect.getConnection();
		
	
		String updatestatement = "insert into customer (username,email,mobilenumber,password)values('" + userBean.getUsername()
		              		+ "','" + userBean.getEmail() + "','" + userBean.getMobilenumber() + "','" + userBean.getPassword() + "')";
		try {
			statement = connection.createStatement();
		
		
			statement.executeUpdate(updatestatement);
		
		
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static int checkLogin(String username,String password)
{
	connection=Connect.getConnection();
	ResultSet rs= null;
	PreparedStatement ps=null;
	int cid=0;
	String select="select * from customer where username=? and password=?";
	try {
		ps = connection.prepareStatement(select);
	
		ps.setString(1, username);
	
		ps.setString(2, password);
	
		rs=ps.executeQuery();
	
		if(rs.next())
			cid=rs.getInt("customerid");
	
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cid;
}
public static List<Samsung> DisplaySamsung()
{
	Blob blob;
	ArrayList<Samsung>list=new ArrayList<Samsung>();
	try
	{
	    connection=Connect.getConnection();
		 statement=connection.createStatement();
		
		String samsungquery="select * from samsung";
		
		ResultSet rs=null;
		    
			rs = statement.executeQuery(samsungquery);
			
		
					while(rs.next())
					{
						Samsung samsung=new Samsung();
						samsung.setProductid(rs.getInt("productid"));
						samsung.setBrand(rs.getString("brand"));
						samsung.setCamera(rs.getInt("camera"));
						samsung.setExpandablememory(rs.getInt("expandablememory"));
						
						
					blob=rs.getBlob("image");
					InputStream is =null;
					is=blob.getBinaryStream();
					ByteArrayOutputStream os=new ByteArrayOutputStream();
					byte[] buffer=new byte[4096];
					int bytesRead=-1;
					while((bytesRead=is.read(buffer))!=-1)
					{
						os.write(buffer,0,bytesRead);
					}
						byte[]imagebyte=os.toByteArray();
						String image=Base64.getEncoder().encodeToString(imagebyte);
						is.close();
						os.close();
						samsung.setImage(image);
						samsung.setModel(rs.getString("model"));
						samsung.setPrice(rs.getString("price"));
						samsung.setStock(rs.getInt("stock"));
						list.add(samsung);
						
					}
				    rs.close();
				    connection.close();
					
					       
				} catch (SQLException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	return list;							
				
}



/**
 * @param customerid
 * @param productid
 */
public static void addToCart(int customerid,int productid)
{
	connection=Connect.getConnection();
	
	String cquery="insert into cart (customerid,productid) values('"+customerid+"','"+productid+"')";
	try {
		statement=connection.createStatement();
	
		statement.executeUpdate(cquery);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
public static void deleteCart(int customerid,int productid)
{
	Statement st=null;
	
	
	connection=Connect.getConnection();
	String rcart="delete from cart where productid='"+productid+"' and customerid='"+customerid+"'";
	try {
		st=connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		st.executeUpdate(rcart);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
		
	
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
public static List<Samsung> customerCart(int customerid)
{
	List<Samsung>list=new ArrayList<Samsung>();
	ResultSet rs=null;
	Blob blob=null;
	connection=Connect.getConnection();
	 try {
		statement=connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String cartquery="select * from samsung inner join cart on samsung.productid = cart.productid where cart.customerid='"+customerid+"'";
	try {
		rs=statement.executeQuery(cartquery);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 try {
		while(rs.next())
		 {
				
				Samsung samsung= new Samsung();
				
				samsung.setBrand(rs.getString("brand"));
				samsung.setCamera(rs.getInt("camera"));
				samsung.setExpandablememory(rs.getInt("expandablememory"));
				blob=rs.getBlob("image");
				InputStream is =null;
				is=blob.getBinaryStream();
				ByteArrayOutputStream os=new ByteArrayOutputStream();
				byte[] buffer=new byte[4096];
				int bytesRead=-1;
				try {
					while((bytesRead=is.read(buffer))!=-1)
					{
						os.write(buffer,0,bytesRead);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					byte[]imagebyte=os.toByteArray();
					String image=Base64.getEncoder().encodeToString(imagebyte);
					try {
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					samsung.setImage(image);
					samsung.setProductid(rs.getInt("productid"));
					samsung.setModel(rs.getString("model"));
					samsung.setPrice(rs.getString("price"));
					samsung.setStock(rs.getInt("stock"));
					list.add(samsung);
			}
	} 
	 
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally {
		 
		 
		 try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 return list; 
}
public static boolean checkCart(int customerid, int productid) {
	// TODO Auto-generated method stub
	
	ResultSet rs= null;
	PreparedStatement ps=null;
	try {
	connection=Connect.getConnection();

	String select="select * from cart where customerid=? and productid=?";
	
		ps = connection.prepareStatement(select);
	
		ps.setInt(1, customerid);
	
		ps.setInt(2, productid);
	
		rs=ps.executeQuery();
	
		if(rs.next())
			return true;
	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	return  false;
}





}
