<%@page import="com.eticaret.DAO.UrunDAO"%>
<%@page import="com.eticaret.model.Kategori"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.eticaret.DAO.KategoriDAO" %>
<%@page import="com.eticaret.DAO.UrunDAO" %>
<%@page import="com.eticaret.model.Kategori" %>
<%@page import="com.eticaret.model.Urun" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="header.jsp"%>
         
   
</head><!--/head-->

<body>
	
	
	<%@ include file="navbar.jsp"%>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2></h2></br></br></br></br></br></br></br></br></br></br></br>
						<!-- <h2>Kategoriler</h2>
						<div class="panel-group category-products" id="accordian">
							<% ArrayList<Kategori> kategoriler=KategoriDAO.tumKatagoriler();%>							
							<%for(Kategori kategori:kategoriler) { %>
								<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="<%=kategori.getKategoriAdi()%>"><%=kategori.getKategoriAdi()%></a></h4>
								</div>
								</div>
							<%} %>												
						</div>-->
														
						
						<div class="shipping text-center"><!--shipping-->
							<img src="${pageContext.request.contextPath}/images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
					
					</div>
				</div>										
																							
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">ÜRÜNLER</h2>
						<% ArrayList<Urun> urunler = UrunDAO.bayanKategoriGetir();%>
						<%if(urunler.size()==0){%>
						<h2>Ürün Bulunamadı</h2>
						<%} %>	
                		<% for(Urun urun: urunler){ %>
                		<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="resimgetir?urunResim=<%=urun.getUrunId()%>" alt="" style="height: 237px;"/>
											<h2><%=urun.getUrunFiyat()%> TL</h2>
											<p><%=urun.getUrunAd()%></p>
											<a href="sepetekle?urunID=<%=urun.getUrunId()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Sepete Ekle</a>
										</div>										
								</div>
								
							</div>
						</div>
						<%} %>			
					</div>																																					
				</div>
			</div>
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