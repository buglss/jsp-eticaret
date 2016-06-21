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
	
	<div id="wrapper container">

        <%@ include file="navbar.jsp"%>
        
	    <div class="container">
	        <div class="row">
	        	<h2 class="title text-center">Kullanıcı EKLEYİNİZ </h2>
	            <div class="col-md-6 col-md-offset-3">
	                <div class="login-panel panel panel-default z-depth-2">
	                    <div class="panel-body">
	                        <form role="form" method="post" action="http://localhost:8080/e-ticaret/JSP/CreateUser">
	                            <fieldset>                                 
									<div class="form-group">
	                                    <select name="roleId" class="form-control">
	                                    	<option value="1">Admin</option>
	                                    	<option value="2">Kullanıcı</option>
	                                    </select>
	                                </div>                            
									<div class="form-group">
	                                    <input class="form-control" placeholder="Adı" name="first_name" type="text" />
	                                </div>
									<div class="form-group">
	                                    <input class="form-control" placeholder="Soyadı" name="last_name" type="text" />
	                                </div>
									<div class="form-group">
	                                    <input class="form-control" placeholder="Eposta" name="email" type="text" />
	                                </div>
									<div class="form-group">
	                                   <input class="form-control" placeholder="Şifre" name="password" type="password" />
	                                </div>
									<div class="form-group">
	                                   <input class="form-control" placeholder="Şehir" name="city" type="text" />
	                                </div>
	                                <button type="submit" class="btn btn-lg btn-success btn-block">Kullanıcı Ekle</button>
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