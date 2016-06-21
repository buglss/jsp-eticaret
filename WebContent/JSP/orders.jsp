<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.eticaret.DAO.OrderDAO"%>
<%@page import="com.eticaret.DAO.CategoryDAO"%>
<%@page import="com.eticaret.model.Order" %>
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
	                	<h2 class="title text-center">ÜRÜN İŞLEMLERİ </h2>
	                </div>
	            </div>
	            <!-- /.row -->
	            <div class="row">
	                <div class="col-lg-12">
	                
	                    <div class="panel panel-default z-depth-2">
	                      
	                        <div class="panel-body">
	                            <div class="dataTable_wrapper">
	                                <table class="table table-striped  table-hover" id="dataTables-example">
	                                    <thead>
	                                        <tr>
	                                            <th>Ürün Adı</th>
												<th>Resim</th>
	                                            <th>Açıklama</th>
	                                            <th>Kategori</th>
	                                            <th>Fiyat</th>
												<th>Miktar</th>  
												<th>İşlemler</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                    <% ArrayList<Order> orders = OrderDAO.getAllOrders();%>
	                					<% for(Order order:orders){ %>
	                                        <tr class="odd gradeX">
	                                            <td><%= order.getName() %></td>
	                                            <td><img src="GetOrderImg?image=<%= order.getId()%>" alt=""/></td>
	                                            <td><%= order.getDescription()%></td>
	                                             <td class="center">
	                                            <%=CategoryDAO.getCategoryName(order.getCategoryId())%>
	                                            </td>
	                                            <td class="center"><%=order.getPrice() %></td>
												<td class="center"><%=order.getTotal()%></td>
												<td><a href="http://localhost:8080/e-ticaret/RemoveOrder?delete=<%=order.getId()%>" name="delete" class="btn btn-block btn-danger pull-left" >Sil</a></td>
	                                        </tr>
										<%} %>
	                                        
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	                    <a href="http://localhost:8080/e-ticaret/JSP/createOrder.jsp" class="z-depth-2 btn btn-success pull-right buy-button" >Ürün Ekle</a>
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

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

</body>

</html>