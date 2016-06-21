package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.eticaret.model.User;

public class LoginDAO {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;

	public static ArrayList<User> getAllUser() throws SQLException {
		ArrayList<User> allUsers = new ArrayList<User>();
		String sql = "SELECT U.id, U.first_name, U.last_name, U.email, U.city, U.role_id "
				+ "FROM users AS U order by id asc";
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setCity((rs.getString(5)));
				user.setRoleId(rs.getInt(6));
				
				allUsers.add(user);
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionDAO.thisClose(con, psmt, rs);
		}
		return allUsers;
	}

	public static int destroyUser(int id) throws SQLException {
		int status = 0;
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement("DELETE FROM users WHERE id=?;");
			psmt.setInt(1, id);
			status = psmt.executeUpdate() > 0 ? 1 : 0;			
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
		return status;
	}

	public static int createUser(User user){
		int state = 0;
		String sql = "INSERT INTO users (first_name,last_name,email,password,city,role_id) VALUES(?,?,?,md5(md5(?)),?,?)";
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getEmail());
			psmt.setString(4, user.getPassword());
			psmt.setString(5, user.getCity());
			psmt.setInt(6, user.getRoleId());
			state = psmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				ConnectionDAO.thisClose(con, psmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return state;
	}
	public static User getUserControl(String email, String password){
		User user = null;
		String sql = "SELECT id,first_name,last_name,role_id FROM users WHERE email=? and password = ?;";
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setRoleId(rs.getInt(4));
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				ConnectionDAO.thisClose(con, psmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
}