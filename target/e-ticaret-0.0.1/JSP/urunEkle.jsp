<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,com.eticaret.model.*" %>
<%@page import="com.eticaret.DAO.*" %>
<% ArrayList<Kategori> kategoriler=KategoriDAO.tumKatagoriler();%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ürün Ekle - E-Ticaret </title>
<%@ include file="headerAdmin.jsp"%> 
</head>

<body>
	<%if(session.getAttribute("admin")==null){
	response.sendRedirect("admin");}%>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Ürün Ekleyiniz</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="UrunEkle" enctype="multipart/form-data">
                            <fieldset>                                
                                <div class="form-group">                                   
									<select class="form-control" name="formKategori">
									<%for(Kategori kategori:kategoriler) { %>
										<option value="<%=kategori.getKategoriID()%>"><%=kategori.getKategoriAdi()%></option>
									<%} %>	
									</select>
													
							
                                </div>
								<div class="form-group">
                                    <input class="form-control" placeholder="Ürün Adı" name="urunAd" type="text" autofocus>
                                </div>
								<div class="form-group">
                                    <input class="form-control" placeholder="Açıklama" name="urunAciklama" type="text" autofocus>
                                </div>
								<div class="form-group">
                                    <input class="form-control" placeholder="Fiyat" name="urunFiyat" type="text" autofocus>
                                </div>
								<div class="form-group">
                                   <input class="form-control" placeholder="Stok" name="urunMiktar" type="text" autofocus>
                                </div>
                                <div class="form-group">
									Resim Yükle<input type="file" name="resim">
								</div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-warning btn-block">Ürün Ekle</button>
                            </fieldset>
                        </form>
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