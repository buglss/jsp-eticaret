package com.eticaret.servlets;


import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.eticaret.DAO.OrderDAO;
import com.eticaret.model.Order;


@WebServlet("/CreateOrder")
@MultipartConfig(maxFileSize = 16177215) 
public class CreateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("order_name");
		String description = request.getParameter("order_description");
		int price = Integer.parseInt(request.getParameter("order_price"));
		int total = Integer.parseInt(request.getParameter("order_total"));
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		
	
		if(name != null && price != 0 && total != 0){
			Order order = new Order();
			order.setName(name);
			order.setDescription(description);
			order.setTotal(total);
			order.setPrice(price);
			order.setImage("");
			order.setCategoryId(category_id);
			
			int is_success = OrderDAO.createOrder(order);
			
			if(is_success != 0){
				response.sendRedirect("JSP/index.jsp");	
			} else {	
				System.out.println("Yanlış giden birşeyler var. Lütfen herşeyi kontrol edip tekrar deneyiniz.");
				response.sendRedirect("JSP/createOrder.jsp");
			}
		}
		else {			
			System.out.println("Girdiğiniz alanları kontrol edip tekrar deneyiniz.");
			response.sendRedirect("JSP/createOrder.jsp");
		}
		
	}

}
