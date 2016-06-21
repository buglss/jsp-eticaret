package com.eticaret.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.LoginDAO;
import com.eticaret.model.Order;
import com.eticaret.model.User;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_email = request.getParameter("email");
		String user_password = request.getParameter("password");
		if (user_email != null && user_password != null) {
			User user = LoginDAO.getUserControl(user_email, user_password);
			if (user  != null && user.getRoleId() == 1) {
				request.getSession().setAttribute("admin", user);
				ArrayList<Order> orders = new ArrayList<Order>();
				request.getSession().setAttribute("cart", orders);
				response.sendRedirect("JSP/dashboard.jsp");
			} else if (user != null ){
				if(user.getRoleId() == 1 || user.getRoleId() == 2){
					ArrayList<Order> orders = new ArrayList<Order>();
					request.getSession().setAttribute("cart", orders);
					request.getSession().setAttribute("user", user);	
					response.sendRedirect("JSP/index.jsp");
				}
			} else {
				request.setAttribute("status", "Geçersiz e-posta adresi veya şifre. Lütfen kontrol ediniz.");
				request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("index");
		}
	}

}