<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.eticaret.model.Order" %>
<%@page import="com.eticaret.model.User"%>
<%@page import="com.eticaret.DAO.LoginDAO"%>
<%@page import="com.eticaret.DAO.OrderDAO"%>
<!DOCTYPE html>
<html lang="en">

<head>
 	<%@ include file="header.jsp"%> 
</head>

<body>
	<% 
		if(session.getAttribute("admin")==null){
			response.sendRedirect("login");
		}
	%>

    <div id="wrapper container">

        <%@ include file="navbar.jsp"%>

        <div id="cart_items">
        	<div class="container">
	            <div class="row">
	                <div class="col-md-12">
	                    <h2 class="title text-center">KULLANICILAR </h2>
	                </div>
	            </div>
			
	            <div class="row">
	                <div class="col-md-12">
	                            <div class="table-responsive cart_info z-depth-2">
	                                <table class="table table-condensed z-depth-2" id="dataTables-example">
	                                    <thead>
	                                        <tr class="cart_menu">
	                                        	<th>Rol</th>
	                                            <th>İsim</th>
												<th>Mail</th>
	                                            <th>Şehir</th>                                            
												<th>İşlemler</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                    <% ArrayList<User> users = LoginDAO.getAllUser();%>
	                					<% for(User user:users){ %>
	                                        <tr class="odd gradeX">
	                                        	<td><%= user.getRoleId()%></td>
	                                            <td><%= user.getFirstName() + "" + user.getLastName() %></td>
	                                            <td><%= user.getEmail()%></td>
	                                            <td><%= user.getCity()%></td>
	                                           
												<td><a href="http://localhost:8080/e-ticaret/JSP/DestroyUser?delete=<%=user.getId()%>" name="delete" class="btn btn-danger btn-large" style="width:100%;float:left;">Sil</a></td>
	                                        </tr>
										<%} %>
	                                        
	                                    </tbody>
	                                </table>
	                            </div>
	                            <a href="http://localhost:8080/e-ticaret/JSP/createUser.jsp" class="z-depth-2 btn btn-small btn-success pull-right buy-button">Kullanıcı Ekle</a>
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

</body>

</html>