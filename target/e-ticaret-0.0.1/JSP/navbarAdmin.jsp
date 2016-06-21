<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="indexAdmin"></a>
            </div>
           

            <ul class="nav navbar-top-links navbar-right">                                                                                     
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> Hatice Güneş <i></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">                       
                        <li><a href="AdminLogout"><i></i> Çıkış Yap</a>
                        </li>
                    </ul>                   
                </li>  
            </ul>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu" style="font-size: 25px;">
                    
                            <a href="dashboard"><i></i> Anasayfa</a>
                            <a href="urunler"><i></i> Ürün </a>                                            
                            <a href="adminMusteri"><i></i>Müşteri </a>
                            <a href="siparisler"><i></i> Siparişler</a>
                    </ul>
                </div>         
            </div>
        </nav>