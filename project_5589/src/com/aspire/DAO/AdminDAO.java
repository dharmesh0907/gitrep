package com.aspire.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.aspire.bean.UserBean;
import com.aspire.connect.Connect;
import com.aspire.products.Mi;
import com.aspire.products.Samsung;


public class AdminDAO
{
     static Connection connection=null;
     PreparedStatement ps;
     static InputStream is=null;
      static Statement st=null;
	public static void addSamsung(Samsung Samsung,Part part) {
		connection = Connect.getConnection();
		try {
			
				is= part.getInputStream();
			
		
		
		// ResourceBundle resourceBundle= ResourceBundle.getBundle("mysql");
		String updatestatement = "insert into samsung (brand,model,stock,price,camera,expandablememory,image) values (?,?,?,?,?,?,?)";
				PreparedStatement statement=null;
				
					statement = connection.prepareStatement(updatestatement);
				
					statement.setString(1, Samsung.getBrand());
				
					statement.setString(2, Samsung.getModel());
				
					statement.setInt(3, Samsung.getStock());
				
					statement.setString(4, Samsung.getPrice());
				
					statement.setInt(6, Samsung.getExpandablememory());
				
					statement.setInt(5, Samsung.getCamera());
				
					statement.setBlob(7, is);
				
			statement.executeUpdate();
		
			connection.close();
		}
				catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void addMi(Mi mi,Part part) {
		connection = Connect.getConnection();
		try {
			 is= part.getInputStream();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		// ResourceBundle resourceBundle= ResourceBundle.getBundle("mysql");
		String updatestatement = "insert into mi (brand,model,stock,price,frontcamera,rearcamera,image) values (?,?,?,?,?,?,?)";
				PreparedStatement statement=null;
				try {
					statement = connection.prepareStatement(updatestatement);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					statement.setString(1, mi.getBrand());
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					statement.setString(4, mi.getPrice());
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					statement.setInt(3, mi.getStock());
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					statement.setInt(5, mi.getFrontcamera());
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					statement.setInt(6, mi.getRearcamera());
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					statement.setString(2, mi.getModel());
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
				try {
					statement.setBlob(7, is);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}		
		try {
			statement.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	public static List<UserBean> showCustomer()
	{
		
		List<UserBean> list = new ArrayList<UserBean> (); 
		ResultSet rs=null;
		connection=Connect.getConnection();
		String custquery="select * from customer";
		
		try {
			st=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=st.executeQuery(custquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				UserBean userbean=new UserBean();
				userbean.setUsername(rs.getString("username"));
				userbean.setEmail(rs.getString("email"));
				userbean.setMobilenumber(rs.getString("mobilenumber"));
				list.add(userbean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
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
		return list;
	}	
	public static List<Samsung> showSamsung()
	{
		
		List<Samsung> list = new ArrayList<Samsung>(); 
		ResultSet rs=null;
		connection=Connect.getConnection();
		String samquery="select * from samsung";
		
		try {
			st=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=st.executeQuery(samquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				Samsung samsung= new Samsung();
				samsung.setProductid(rs.getInt("productid"));
				samsung.setBrand(rs.getString("brand"));
				samsung.setCamera(rs.getInt("camera"));
				samsung.setStock(rs.getInt("stock"));
				samsung.setExpandablememory(rs.getInt("expandablememory"));
				
				samsung.setModel(rs.getString("model"));
				samsung.setPrice(rs.getString("price"));
				list.add(samsung);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
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
		return list;
	}	
	public static void deleteProducts(String brand,int productid)
	{
		connection=Connect.getConnection();
		String dquery="delete from "+brand+" where productid='"+productid+"'";
		try {
			st=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.executeUpdate(dquery);
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
	public static void deleteCart(int productid)
	{
		connection=Connect.getConnection();
		String dcart="delete from cart where productid='"+productid+"'";
		try {
			st=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.executeUpdate(dcart);
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
	public static void updateProducts(String brand,int productid,String price)
	{
	  connection=Connect.getConnection();
	  String uquery="UPDATE "+brand+" SET price = '"+price+"'WHERE productid = '"+productid+"'";
		try {
			st=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.executeUpdate(uquery);
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
		public static void updateCart(String brand,int productid,String price)
		{
		  connection=Connect.getConnection();
		  String uquery="UPDATE "+brand+" SET price = '"+price+"'WHERE productid = '"+productid+"'";
			try {
				st=connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.executeUpdate(uquery);
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
	
	
	
}
