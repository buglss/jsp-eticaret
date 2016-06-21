<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.eticaret.servlets.UserLogin" %>
<!DOCTYPE html>
<html lang="en">
<head>
		
        <%@ include file="header.jsp"%>
        <title>Kullanıcı Girişi | eticaret</title>
    	
</head>
<body>
	
	<section id="form">
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<div class="login-form z-depth-4">
						<h2><i class="fa fa-power-off" aria-hidden="true"></i> Giriş Yapınız</h2>
						<form role="form" method="post" action="UserLogin">							
							<i class="fa fa-envelope login_icon" aria-hidden="true"></i><input name="email" type="email" placeholder="Mail Adresi" />
							<i class="fa fa-key login_icon" aria-hidden="true"></i><input name="password" type="password" placeholder="Şifre" />
							<span>
								<input type="checkbox" class="checkbox"> 
								Beni hatırla
							</span>
							<button type="submit" class="btn btn-success">Giriş</button>
						</form>
					</div>
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