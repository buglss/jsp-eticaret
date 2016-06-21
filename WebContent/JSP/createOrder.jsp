<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList,com.eticaret.model.*" %>
<%@page import="com.eticaret.DAO.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<%@ include file="header.jsp"%> 
</head>

<body>
	<%
		if(session.getAttribute("admin")==null){
			response.sendRedirect("admin");
		}
	%>
	
	<% ArrayList<Category> categories = CategoryDAO.allCategories();%>	
	<div id="wrapper container">

        <%@ include file="navbar.jsp"%>
	    <div class="container">
	        <div class="row">
	        	<h2 class="title text-center">ÜRÜN EKLEYİNİZ </h2>
	            <div class="col-md-6 col-md-offset-3">
	                <div class="login-panel panel panel-default z-depth-2">
	                    <div class="panel-body">
	                        <form role="form" method="post" action="../CreateOrder" >
	                            <fieldset>                                
	                                <div class="form-group">                                   
										<select class="form-control" name="category_id">
											<%for(Category category:categories) { %>
												<option value="<%=category.getId()%>"><%=category.getName()%></option>
											<%} %>	
										</select>				
	                                </div>
									<div class="form-group">
	                                    <input class="form-control" placeholder="Ürün Adı" name="order_name" type="text" >
	                                </div>
									<div class="form-group">
	                                    <input class="form-control" placeholder="Açıklama" name="order_description" type="textarea" >
	                                </div>
									<div class="form-group">
	                                    <input class="form-control" placeholder="Fiyat" name="order_price" type="text" >
	                                </div>
									<div class="form-group">
	                                   <input class="form-control" placeholder="Stok" name="order_total" type="text" >
	                                </div>
	                                <div class="form-group">
										Resim Yükle<input type="file" name="image">
									</div>
	                                <!-- Change this to a button or input when using this as a form -->
	                                <button type="submit" class="btn btn-lg btn-success btn-block">Ürün Ekle</button>
	                            </fieldset>
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
   </div>

    <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
    
 

</body>
</html>