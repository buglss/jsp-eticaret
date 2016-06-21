package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.eticaret.model.Role;

public class RoleDAO {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;

	public static ArrayList<Role> allRoles() throws SQLException {
		ArrayList<Role> roles = new ArrayList<Role>();
		String sql = "SELECT * FROM roles order by id asc;";
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				roles.add(new Role(rs.getInt(1), rs.getString(2)));
			}
			con.close();
		} catch (final SQLException ex) {
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
		return roles;
	}
	public static int createRole(Role role) throws SQLException {
		int state = 0;
		String sql = "INSERT INTO roles(name) VALUES(?);";
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, role.getName());
			state = psmt.executeUpdate();
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
		return state;
	}

	public static int destroyRole(Role role) throws SQLException {
		int state = 0;
		String sql = "DELETE FROM roles Where id = ?;";
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, role.getId());
			state = psmt.executeUpdate();
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
		return state;
	}

	public static int updateRole(Role role) throws SQLException {
		int state = 0;
		String sql = "UPDATE roles Set name = ? Where id = ?";
		try {
			con = ConnectionDAO.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, role.getName());
			psmt.setInt(2, role.getId());
			state = psmt.executeUpdate();
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
		return state;
	}
	
}
