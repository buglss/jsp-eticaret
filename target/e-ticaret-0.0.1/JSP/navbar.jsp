<%@page import="com.eticaret.model.Musteri"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.eticaret.model.Kategori" %>
<%@page import="com.eticaret.DAO.KategoriDAO" %>
<%@page import="java.util.ArrayList" %>
<header id="header">
<%
Musteri musteri = (Musteri)session.getAttribute("musteri");

%>
		<div class="header_top">
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> 0362 738 19 64</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> hatice.gunes@bil.omu.edu.tr</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle">
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
						</div>					
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="cart"><i class="fa fa-shopping-cart"></i> Sepet</a></li>
								
								<%
								if(session.getAttribute("musteri") != null){
									Musteri m=(Musteri)session.getAttribute("musteri");
									if(m.getMusteriAdi()!=null){
									%>
									  <li class="dropdown"><a href="login"><%=musteri.getMusteriAdi()%><i class="fa fa-angle-down"></i></a>
                                      <ul role="menu" class="sub-menu">
                                        <li><a method="post" href="cikis" style="background-color: #696763;">Çıkış</a></li>
                                      </ul>
                                      </li>
									<%}else{%>
										<li><a href="login"><i class="fa fa-lock"></i> Giriş</a></li><%
									}
								}
								else{%>
									<li><a href="login"><i class="fa fa-lock"></i> Giriş</a></li><%
								}%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom">
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index" class="active">Anasayfa</a></li>
								<% ArrayList<Kategori> kategoriler2=KategoriDAO.tumKatagoriler();%>							
							    <%for(Kategori kategori:kategoriler2) { %>
							          <li ><a href="kategoriList?kid=<%=kategori.getKategoriID() %>"><%=kategori.getKategoriAdi()%></a></li>
							    <%} %>
								
								
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>