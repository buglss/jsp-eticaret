package com.eticaret.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eticaret.model.User;
import com.eticaret.model.Order;
import com.eticaret.model.Cart;
import com.eticaret.DAO.CartDAO;

import java.text.DateFormat;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ComplateCarts")
public class CompleteCarts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("user")!=null || request.getSession().getAttribute("admin")!=null ){
			Cart cart=new Cart();
			
			User user =(User) request.getSession().getAttribute("user") ;
			User admin =(User) request.getSession().getAttribute("admin") ;
			@SuppressWarnings("unchecked")
			ArrayList<Order> orders = (ArrayList<Order>) request.getSession().getAttribute("cart");
			
			 	Date current_time = new Date();
		        System.out.println(current_time.toString());
		        DateFormat short_date = new SimpleDateFormat("dd/MM/yyyy");
			
			for(int i=0; i < orders.size() ; i++){
				cart.setTotal(1);
				cart.setPrice(orders.get(i).getPrice());
				cart.setDate(short_date.format(current_time));
				cart.setOrderId(orders.get(i).getId());
				if(user != null){
					cart.setUserId(user.getId());
					CartDAO.completeCart(cart,user);
				}
				else{
					cart.setUserId(admin.getId());
					CartDAO.completeCart(cart,admin);
				}
				
			}
			clear(orders);
		}
		response.sendRedirect("JSP/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void clear(ArrayList<Order> order_list) {
		order_list.clear();
	}

}
