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

@WebServlet("/GetOrders")
public class GetOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String this_category_id = request.getParameter("category_id");
		ArrayList<Order> orders = null;
		if(this_category_id != null && !this_category_id.equals("")){
			int category_id = Integer.parseInt(this_category_id);
			try {
				orders = OrderDAO.getAllOrdersByCategory(category_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(orders != null){
			request.setAttribute("category_id", this_category_id);
		}
		request.getRequestDispatcher("JSP/index.jsp").forward(request, response);
	}
}
