<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.eticaret.model.User"%>
<%@page import="com.eticaret.model.Category" %>
<%@page import="com.eticaret.DAO.CategoryDAO" %>
<%@page import="java.util.ArrayList" %>
<header id="header">

		<div class="header_top">

		</div>
		
		<div class="header-middle z-depth-2">
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
						</div>					
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">

								<%
								if(session.getAttribute("admin") != null){
									User u = (User)session.getAttribute("admin");
									if(u!=null){
									%>
									  <li><a href="http://localhost:8080/e-ticaret/JSP/cart.jsp"><i class="fa fa-shopping-cart"></i> Sepet</a></li>                                           
		                              <li><a href="http://localhost:8080/e-ticaret/JSP/dashboard.jsp"><i class="fa fa-user" aria-hidden="true"></i> Kullanıcı </a></li>
		                              <li><a href="http://localhost:8080/e-ticaret/JSP/orders.jsp"><i class="fa fa-archive" aria-hidden="true"></i> Ürün </a></li>
		                              <li><a href="http://localhost:8080/e-ticaret/JSP/carts.jsp"><i class="fa fa-globe" aria-hidden="true"></i> Sipariş</a></li>
									  <li class="dropdown user-dropdown">
                                      <button class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
									    <%=u.getFirstName()%>
									    <span class="caret"></span>
									  </button>
                                      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <center><li><a method="post" href="http://localhost:8080/e-ticaret/UserLogout">Çıkış</a></li></center>
                                      </ul>
                                      </li>
									<%} 
								}
								else{
									
									User user = (User)session.getAttribute("user");
										if(user != null) {%>
											<li><a href="http://localhost:8080/e-ticaret/JSP/cart.jsp"><i class="fa fa-shopping-cart"></i> Sepet</a></li>
											<li class="dropdown user-dropdown">
											<button class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
										    <%=user.getFirstName()%>
										    <span class="caret"></span>
										  </button>
	                                      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
	                                        <center><li><a method="post" href="http://localhost:8080/e-ticaret/UserLogout">Çıkış</a></li></center>
	                                      </ul>
	                                      </li>
										 <%} else { %>
											<li><a href="http://localhost:8080/e-ticaret/JSP/cart.jsp"><i class="fa fa-shopping-cart"></i> Sepet</a></li>
											<li><a href="http://localhost:8080/e-ticaret/login"><i class="fa fa-lock"></i> Giriş</a></li>
										<%}
								}
									%>
							</ul>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<div class="header-bottom">
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="http://localhost:8080/e-ticaret/JSP/index.jsp">Anasayfa</a></li>
								<% ArrayList<Category> this_categories = CategoryDAO.allCategories();%>							
							    <%for(Category category:this_categories) { %>
							          <li ><a href="http://localhost:8080/e-ticaret/GetOrders?category_id=<%=category.getId() %>"><%=category.getName()%></a></li>
							    <% } %>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>