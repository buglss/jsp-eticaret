<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.eticaret.model.Order" %>
<%@page import="com.eticaret.DAO.OrderDAO" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    
    <%@ include file="header.jsp"%>
    <title>Sepetim | Eticaret</title>
  
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<section id="cart_items">
		<div class="container">
			
			<div class="table-responsive cart_info z-depth-2">
				<table class="table table-condensed z-depth-2">
					<thead>
						<tr class="cart_menu">
							<td class="image">Ürün</td>
							<td class="description">Açıklama</td>
							<td class="price">Fiyat</td>														
							<td></td>
						</tr>
					</thead>
					<tbody>
					<%if(session.getAttribute("cart")!=null){ %>
						<%ArrayList<Order> orders=(ArrayList<Order>)session.getAttribute("cart");%>
						<%  
							int i=0;
							int toplam=0;
							for(Order this_order:orders) { 
						    	toplam+=this_order.getPrice();
						 %>						
						<tr>
							<td class="cart_product">
								<a href=""><img src="GetOrderImg?image=<%=this_order.getId()%>" alt="" /></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><%= this_order.getName() %></a></h4>
								<p><%= this_order.getDescription() %></p>
							</td>
							<td class="cart_price">
								<p><%=this_order.getPrice()%> TL</p>
							</td>														
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="http://localhost:8080/e-ticaret/RemoveOrder?order_id=<%= i %>"><i class="fa fa-times"></i></a>
							</td>
						</tr>
							<%i++;
							}
						}%>						
						
					</tbody>
				</table>   
		             
			</div>
			<a  class="btn btn-success buy-button pull-right z-depth-2" href="http://localhost:8080/e-ticaret/ComplateCarts">Satın Al</a>
		</div>
		
	</section>

	<%@ include file="footer.jsp"%>
	
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>