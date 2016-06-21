package com.eticaret.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eticaret.DAO.LoginDAO;
import com.eticaret.model.User;
import com.eticaret.model.Order;



@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String first_name = request.getParameter("first_name"); 
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String city= request.getParameter("city");
		String roleId= request.getParameter("roleId");
		
		if( email != null && password != null ){
			User user=new User();
			if (first_name != null) { 
				user.setFirstName(first_name);
			} else { 
				user.setFirstName("Yeni");
			}
			if (last_name != null) { 
				user.setLastName(last_name);
			} else { 
				user.setLastName("Kullanıcı");
			}
			user.setEmail(email);
			user.setPassword(password);
			user.setCity(city);
			user.setRoleId(Integer.parseInt(roleId));
			
			int is_succes = LoginDAO.createUser(user);
			
			if(is_succes != 0){
				ArrayList<Order> orders = new ArrayList<Order>();
				request.getSession().setAttribute("orders", orders);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("JSP/index.jsp");
			}else{				
				request.getRequestDispatcher("JSP/index.jsp").forward(request, response);
			}
		}
		else{			
			request.getRequestDispatcher("JSP/orders.jsp").forward(request, response);
		}
	}

}
