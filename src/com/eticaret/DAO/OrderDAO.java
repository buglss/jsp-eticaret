package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.eticaret.model.Order;

public class OrderDAO {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;

	
	public static ArrayList<Order> getAllOrdersByCategory(int category_id) throws SQLException {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE category_id =?;");
			psmt.setInt(1, category_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setCategoryId(rs.getInt(6));
				
				orders.add(order);
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
		return orders;
	}
	
	public static ArrayList<Order> getAllOrders() throws SQLException {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setCategoryId(rs.getInt(7));
				
				orders.add(order);
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
		return orders;
	}

	public static byte[] getImageByOrder(int order_id) {
		String query = "SELECT image from orders where id=?";
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement psmt;
		byte[] bytesImage = null;
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, order_id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				bytesImage = rs.getBytes("image");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bytesImage;
	}

	public static ArrayList<Order> getPopularOrders() throws SQLException {
		ArrayList<Order> popular_orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE caregory_id=1;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setImage(rs.getString(6));
				order.setCategoryId(rs.getInt(7));

				popular_orders.add(order);
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
		return popular_orders;
	}

	public static Order getOrder(int id) throws SQLException {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE id=?;"); 
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setCategoryId(rs.getInt(7));
				
				orders.add(order);
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
		return orders.get(0);
	}
	
	public static ArrayList<Order> getOrdersByFemale() throws SQLException {
		ArrayList<Order> female_orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE category_id=2;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setImage(rs.getString(6));
				order.setCategoryId(rs.getInt(7));
				
				female_orders.add(order);
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
		return female_orders;
	}
	
	
	public static ArrayList<Order> getOrdersByMale() throws SQLException {
		ArrayList<Order> male_orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE category_id=3;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setImage(rs.getString(6));	
				order.setCategoryId(rs.getInt(7));
				
				male_orders.add(order);
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
		return male_orders;
	}
	
	public static ArrayList<Order> getOrdersByShoe() throws SQLException {
		ArrayList<Order> shoe_orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE category_id=4;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setImage(rs.getString(6));	
				order.setCategoryId(rs.getInt(7));
	
				shoe_orders.add(order);
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
		return shoe_orders;
	}
	
	
	public static ArrayList<Order> getOrdersByAccessory() throws SQLException {
		ArrayList<Order> accessory_orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE category_id=5;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setImage(rs.getString(6));
				order.setCategoryId(rs.getInt(7));

				accessory_orders.add(order);
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
		return accessory_orders;
	}
	
	
	public static ArrayList<Order> getOrdersByElectronic() throws SQLException {
		ArrayList<Order> electronic_orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE category_id=6;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setImage(rs.getString(6));
				order.setCategoryId(rs.getInt(7));
				
				electronic_orders.add(order);
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
		return electronic_orders;
	}
	public static ArrayList<Order> getOrdersBySpor() throws SQLException {
		ArrayList<Order> spor_orders = new ArrayList<Order>();
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("SELECT * FROM orders WHERE category_id=7;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setDescription(rs.getString(3));
				order.setPrice(rs.getFloat(4));
				order.setTotal(rs.getInt(5));
				order.setImage(rs.getString(6));
				order.setCategoryId(rs.getInt(7));
				
				spor_orders.add(order);
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
		return spor_orders;
	}
	public static int destroyOrder(int id) throws SQLException {
		
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("DELETE FROM orders WHERE id="+id+";");
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
	
	public static int createOrder(Order order){
		int state = 0;
		String sql = "INSERT INTO orders(name,description,price,total,image,category_id) VALUES(?,?,?,?,?,?)";
		try {			
			con = ConnectionDAO.getConnection();			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, order.getName());
			psmt.setString(2, order.getDescription());
			psmt.setFloat(3, order.getPrice());
			psmt.setInt(4, order.getTotal());
			psmt.setString(5, order.getImage());
			psmt.setInt(6, order.getCategoryId());

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
	
}
