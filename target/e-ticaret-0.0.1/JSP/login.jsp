<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.eticaret.servlets.MusteriLogin" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<title>Giriş - e-ticaret</title>
        
        <%@ include file="header.jsp"%>
    	
</head><!--/head-->

<body>
	<!--  -->

	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Hesabına Giriş yap</h2>
						<form role="form" method="post" action="MusteriLogin">							
							<input name="musteriMail" type="email" placeholder="Mail Adresi" />
							<input name="musteriSifre" type="password" placeholder="Şifre" />
							<span>
								<input type="checkbox" class="checkbox"> 
								Beni hatırla
							</span>
							<button type="submit" class="btn btn-success">Giriş</button>
						</form>
					</div><!--/login form-->
				</div>
				
			</div>
		</div>
	</section><!--/form-->
	
	<%@ include file="footer.jsp"%>
	<%
	if(request.getAttribute("status")!=null){
		out.print("<script>alert(" + request.getAttribute("status")+ ")</script>");
	}
	%>
</body>
</html>