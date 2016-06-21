<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.eticaret.model.Order" %>
<%@page import="com.eticaret.model.Cart"%>
<%@page import="com.eticaret.DAO.OrderDAO"%>
<%@page import="com.eticaret.DAO.CartDAO"%>
<%@page import="com.eticaret.DAO.CategoryDAO"%>
<!DOCTYPE html>
<html lang="en">

<head>
 	<%@ include file="header.jsp"%> 
</head>

<body>
	<%
		if(session.getAttribute("admin")==null){
			response.sendRedirect("admin");}
	%>

    <div id="wrapper">

        <%@ include file="navbar.jsp"%>

        <div id="page-wrapper">
        	<div class="container">
	            <div class="row">
	                <div class="col-md-12">
	                	<h2 class="title text-center">SİPARİŞLER </h2>
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-md-12">
	                    <div class="panel panel-default">
	                   
	                        <div class="panel-body">
	                            <div class="dataTable_wrapper">
	                                <table class="table table-striped table-hover" id="dataTables-example">
	                                    <thead>
	                                        <tr>
	                                            <th>Müşteri Adı</th>
												<th>Sipariş Tarihi</th>
	                                            <th>Adet</th>
	                                            <th>Fiyat</th>                                    									  
												<th>Sipariş Durumu</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                     <% ArrayList<Cart> carts = CartDAO.getAllCarts();%>
	                					<% for(Cart cart:carts){ %>
	                                        <tr class="odd gradeX">
	                                            <td><%=CartDAO.getUserName(cart.getUserId())%></td>
	                                            <td><%=cart.getDate()%></td>
	                                            <td><%=cart.getTotal()%></td>
	                                            <td><%=cart.getPrice()%></td>
	                                            
	                                            <td><a href="http://localhost:8080/e-ticaret/EmptyCart?delete=<%=cart.getId()%>" name="delete" class="btn btn-danger btn-block">Sil</a></td>																						
	                                        </tr>
										<%} %> 
	                                        
	                                     </tbody>
	                                </table>
	                                <div>Sipariş sayısı: <%=CartDAO.getCartTotal()%></div>
	                            </div>   
	                        </div>
	                    </div>
	                </div>
	            </div>
			</div>
        </div>
    </div>
    
    <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

</body>

</html>