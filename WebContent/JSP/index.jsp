<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.eticaret.DAO.OrderDAO"%>
<%@page import="com.eticaret.DAO.CategoryDAO" %>
<%@page import="com.eticaret.model.Category"%>
<%@page import="com.eticaret.model.Order" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="header.jsp"%>
</head>

<body>
		
	<%@ include file="navbar.jsp"%>
	
	<section>
		<div class="container">
			<div class="row">
				
				<%
					ArrayList<Order> order_list = null;
					if(request.getAttribute("category_id") != null){
						String category_id = request.getAttribute("category_id").toString();
						order_list = OrderDAO.getAllOrdersByCategory(Integer.parseInt(category_id));
					} else {
						order_list = OrderDAO.getAllOrders();
					}
				
				%>
							
				<div class="col-sm-12">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">ÜRÜNLER </h2>
                		<% for(Order order:order_list){ %>
                		<div class="col-sm-4">
							<div class="product-image-wrapper z-depth-2">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="http://localhost:8080/e-ticaret/JSP/shop.png" alt="" />
											<h2><%=order.getPrice()%> TL</h2>
											<p><%=order.getName()%></p>
											<a href="http://localhost:8080/e-ticaret/AddCart?Id=<%=order.getId()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Sepete Ekle</a>
										</div>										
								</div>								
							</div>
						</div>
						<%} %>			
					</div>										
				</div>
				
			</div>
		</div>
	</section>
	
	<%@ include file="footer.jsp"%>
  
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
     
</body>
</html>