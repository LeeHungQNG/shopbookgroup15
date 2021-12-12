<%@page import="model.Cart"%>
<%@page import="java.util.Map"%>
<%@page import="model.Category"%>
<%@page import="dao.CartDAO"%>
<%@page import="model.Users"%>
<%@page import="bo.CategoryBO"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map.Entry"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="java.text.DecimalFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tiêu đề</title>
</head>
<body>
	<%
	CategoryBO category = new CategoryBO();
	%>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Humberger Begin -->
	<div class="humberger__menu__overlay"></div>
	<div class="humberger__menu__wrapper">
		<div class="humberger__menu__logo">
			<a href="#"><img src="viewroot/img/logo.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
				<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
			</ul>
			<div class="header__cart__price">
				item: <span>$150.00</span>
			</div>
		</div>
		<div class="humberger__menu__widget">
			<div class="header__top__right__language">
				<img src="img/language.png" alt="">
				<div>English</div>
				<span class="arrow_carrot-down"></span>
				<ul>
					<li><a href="#">Việt Nam</a></li>
					<li><a href="#">English</a></li>
				</ul>
			</div>
			<div class="header__top__right__auth">
				<a href="#"><i class="fa fa-user"></i>Đăng Nhập/Đăng Ký</a>
			</div>
		</div>
		<nav class="humberger__menu__nav mobile-menu">
			<ul>
				<li class="active"><a href="./index.html">Home</a></li>
				<li><a href="./shop-grid.html">Sản phẩm</a></li>
				<li><a href="#">Bánh</a>
					<ul class="header__menu__dropdown">
						<li><a href="./shop-details.html">Shop Details</a></li>
						<li><a href="./shoping-cart.html">Shoping Cart</a></li>
						<li><a href="./checkout.html">Check Out</a></li>
						<li><a href="./blog-details.html">Blog Details</a></li>
					</ul></li>
				<li><a href="./contact.html">Liên Hệ</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="header__top__right__social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-pinterest-p"></i></a>
		</div>
		<div class="humberger__menu__contact">
			<ul>
				<li><i class="fa fa-envelope"></i> TGMbookstore@gmail.com</li>
				<li>Miễn phi ship 100% cho nội thành</li>
			</ul>
		</div>
	</div>
	<!-- Humberger End -->
	<!-- Bắt đầu tiêu đề -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="header__top__left">
							<ul>
								<li><i class="fa fa-envelope"></i>  TGMbookstore@gmail.com</li>
								<li>Miễn phi ship 100% cho nội thành</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-linkedin"></i></a> <a href="#"><i
									class="fa fa-pinterest-p"></i></a>
							</div>
							<div class="header__top__right__language">
								<img src="viewroot/img/language.png" alt="">
								<div>VIET NAM</div>
								<span class="arrow_carrot-down"></span>
								<ul>
									<li><a href="#">VIET NAM</a></li>
									<li><a href="#">English</a></li>
								</ul>
							</div>
							<div class="header__top__right__auth">
								<%
								if (session.getAttribute("uslogin") != null) {
									// Giá trị session tồn tại 2 giờ 
									Users us = (Users) session.getAttribute("uslogin");
								%>
								<div class="row">
									<a href="HomeProfileServlet?id=<%=us.getId()%>"><i
										class="fa fa-user"></i> <%=us.getNameDisplay()%></a> <a
										href="UsersLogoutServlet"><i class="pe-7s-back"></i> Đăng
										xuất</a>
								</div>
								<%
								} else {
								%>
								<a href="login.jsp"><i class="fa fa-user"></i>Đăng Nhập/Đăng
									ký</a>
								<%
								}
								%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="Home"><img src="viewroot/img/bookstorelogos.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a href="Home">HOME</a></li>
							<li><a href="HomeProductsServlet">SẢN PHẨM</a></li>
							<li><a href="#">SÁCH</a>
								<ul class="header__menu__dropdown">
									<%
									for (Category ds : category.getListCategory()) {
									%>
									<li><a
										href="HomeProductsServlet?id_category=<%=ds.getId()%>"><%=ds.getNameCategory()%>
									</a></li>
									<%
									}
									%>
								</ul></li>
							
							<li><a href="./contact.jsp">LIỆN HỆ</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<%
						Cart cart = (Cart) session.getAttribute("cart");
						double total = 0;
						int amount = 0;
						if (cart != null) {
							total = cart.getTotalPrice();
							amount = cart.getAmount();
						}
						%>
						<ul>
							<li><a href="#"><i class="fa fa-heart"></i> <span>99</span></a></li>
							<li><a id="cart" href="HomeShoppingCart"><i
									class="fa fa-shopping-bag"></i> <span id="count"><%=amount%></span></a></li>
						</ul>
						<div class="header__cart__price">
							Tổng tiền: <span><%=total%></span>
						</div>
					</div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>

	<!-- Xong tiêu đề -->
	<!-- Cài đặt xem trên thiết bị di động -->
	<!-- Xong cài đặt xem trên thiết bị di động -->

</body>
</html>