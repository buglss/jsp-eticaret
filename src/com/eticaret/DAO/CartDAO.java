package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.eticaret.model.Cart;
import com.eticaret.model.User;

public class CartDAO {

	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static int completeCart(Cart cart,User user){
		int state = 0;
		String sql = "INSERT INTO carts(date,prompt,total,price,user_id,order_id) VALUES(?,?,?,?,?,?)";
		try {			
			con = ConnectionDAO.getConnection();			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, cart.getDate());
			psmt.setString(2, cart.getPrompt());
			psmt.setInt(3, cart.getTotal());
			psmt.setFloat(4, cart.getPrice());
			psmt.setInt(5, cart.getUserId());
			psmt.setInt(6, cart.getOrderId());
			state = psmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return state;
	}
	public static ArrayList<Cart> getAllCarts() throws SQLException {
		ArrayList<Cart> carts = new ArrayList<Cart>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM carts;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				
				cart.setId(rs.getInt(1));
				cart.setDate(rs.getString(2));
				cart.setPrompt(rs.getString(3));
				cart.setTotal(rs.getInt(4));
				cart.setPrice(rs.getFloat(5));
				cart.setUserId(rs.getInt(6));
				cart.setOrderId(rs.getInt(7));
				
				carts.add(cart);
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return carts;
	}
	
	public static String getUserName(int id){
		String name = null;
		String sql = "SELECT first_name,last_name from users where id=?;";
		try {
			con = ConnectionDAO.getConnection();
			psmt =  con.prepareStatement(sql);
			psmt.setInt(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){			
				name = rs.getString(1) + " " + rs.getString(2).toUpperCase();
			}
			
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();	
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return name;
	}
	
	public static int getCartTotal(){
		int total = 0;
		String sql = "SELECT COUNT(id) FROM carts;";
		try {
			con = ConnectionDAO.getConnection();
			psmt =  con.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){			
				int number=(rs.getInt(1));
				total=number;
								
			}
			
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();	
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return total;
	}
	
	public static int destroyCarts(int id){
	
		try {
			con = ConnectionDAO.getConnection();
			psmt =  con.prepareStatement("DELETE FROM carts WHERE id="+id+";");
			psmt.executeUpdate();			
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return 1;
	}
	
}
