package com.eticaret.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.eticaret.model.Category;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CategoryDAO {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Category> allCategories() throws SQLException {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		String sql = "SELECT * FROM categories;";
		try{
			
			con = (Connection) ConnectionDAO.getConnection();			
			psmt = (PreparedStatement) con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				categoryList.add(new Category(rs.getInt(1), rs.getString(2)));
			}			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			con.close();
			psmt.close();
			rs.close();			
		}
		
		return categoryList;
	}
	public static String getCategoryName(int categoryId) throws SQLException{
		String category = null;
		String sql="Select * from categories where id="+categoryId+";";
		try{	
			con=(Connection) ConnectionDAO.getConnection();
			psmt=(PreparedStatement) con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				category=rs.getString(2);
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			con.close();
			psmt.close();
			rs.close();
		}
		return category;
		
	}
}
