package com.eticaret.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eticaret.DAO.OrderDAO;
import com.eticaret.model.Order;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parameter = request.getParameter("Id");
		int id = Integer.parseInt(parameter);

		if (request.getSession().getAttribute("user") != null || request.getSession().getAttribute("admin") != null) {
			@SuppressWarnings("unchecked")
			ArrayList<Order> cart = (ArrayList<Order>) request.getSession().getAttribute("cart");
			try {
				cart.add(OrderDAO.getOrder(id));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("index").forward(request, response);
		} else {
			response.sendRedirect("JSP/index.jsp");
		}
	}

}
