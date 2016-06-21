package com.eticaret.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.OrderDAO;

@WebServlet("/DestroyOrder")
public class DestroyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("delete"));
		try {
			OrderDAO.destroyOrder(id);
			response.sendRedirect("JSP/index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
