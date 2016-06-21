<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.eticaret.model.Siparis"%>
	<%@page import="com.eticaret.DAO.SiparisDAO"%>
<!DOCTYPE html>
<html lang="en">

<head>

   <%@ include file="headerAdmin.jsp"%>
   
</head>

<body>
	<%@ include file="navbarAdmin.jsp"%>
    <div id="wrapper">
		<%
			if (session.getAttribute("admin") == null) {
				response.sendRedirect("admin");
			}
		%>


		<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Hoşgeldiniz </h1>
                </div>               
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><%=SiparisDAO.siparisSayisiGetir()%></div>
                                    <div>Yeni Sipariş!</div>
                                </div>
                            </div>
                        </div>
                        <a href="siparisAdmin">
                            <div class="panel-footer">
                                <span class="pull-left"></span>
                                <span class="pull-right"><i></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>                
                
            </div>
            
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                    </div>
                </div>  
          </div>          
        </div>
    </div>
   
    

   
    <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/raphael/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/morris-data.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

</body>

</html>