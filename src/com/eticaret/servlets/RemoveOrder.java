package com.eticaret.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eticaret.model.Order;

@WebServlet("/RemoveOrder")
public class RemoveOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("order_id"));
		@SuppressWarnings("unchecked")
		ArrayList<Order> cart = (ArrayList<Order>) request.getSession().getAttribute("cart");
		cart.remove(id);
		request.getRequestDispatcher("JSP/cart.jsp").forward(request, response);
	}

}
