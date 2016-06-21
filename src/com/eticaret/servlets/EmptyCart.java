package com.eticaret.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eticaret.DAO.CartDAO;


@WebServlet("/EmptyCart")
public class EmptyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("delete");
		if(id != null && !id.equals("")){
			int carts_id = Integer.parseInt(id);
			CartDAO.destroyCarts(carts_id);
		}
		response.sendRedirect("JSP/carts.jsp");
	}

}
