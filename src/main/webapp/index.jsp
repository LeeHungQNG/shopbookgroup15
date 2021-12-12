<%@page import="model.Category"%>
<%@page import="model.Books"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.Writer"%>
<%@page import="model.Category"%>
<%@page import="bo.CategoryBO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<jsp:include page="layout/head.jsp"></jsp:include>
<title>Shop book</title>
</head>

<body>
	<%
		ArrayList<Books> products = (ArrayList<Books>) request.getAttribute("lstProducts");
		ArrayList<Books> productstop8 = (ArrayList<Books>) request.getAttribute("lstProductstop8");
		ArrayList<Category> category = (ArrayList<Category>) request.getAttribute("lstCategory");
	
	%>

	<!-- Thêm phần tiêu đề trang -->
	<jsp:include page="layout/header.jsp"></jsp:include>
	<!-- Xong phần tiêu đề trang -->
	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>Danh Mục Sản Phẩm</span>
						</div>
						<ul>
							<%
													for (Category ds : category) {
												%>
							<li><a
								href="HomeProductsServlet?id_category=<%=ds.getId()%>"><%=ds.getNameCategory()%>
							</a></li>
							<%
													}
												%>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="HomeSearchProduct" method="get">

								<input name="key" type="text" placeholder="Bạn muốn tìm gì?">
								<button type="submit" class="site-btn">TÌM KIẾM</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-phone"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>012345678</h5>
								<span>Hộ trợ 24/7</span>
							</div>
						</div>
					</div>
					<div class="hero__item set-bg"
						data-setbg="viewroot/img/banner/bookbanner.jpg">
						<div class="hero__text">						
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Hero Section End -->

	<!-- Categories Section Begin -->
	<section class="categories">
		<div class="container">
			<div class="row">

				<div class="categories__slider owl-carousel">
					<%
				for (Books ls : products) {
			%>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="viewroot/img/shop/product/<%=ls.getImageDisplay()%>">
							<h5>
								<a href="HomeProductsDetail?id=<%=ls.getId()%>"><%=ls.getNameBook()%></a>
							</h5>
						</div>
					</div>
					<%} %>
				</div>
			</div>
		</div>
	</section>
	<!-- Categories Section End -->

	<!-- Featured Section Begin -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Sản phẩm nỗi bật</h2>
					</div>
					<div class="featured__controls">
						<ul>
							<li class="active" data-filter="*">Tất cả</li>
							<%
				for (int i=0;i<5;i++) {
			%>

							<li data-filter=".oranges<%=category.get(i).getId()%>"><%=category.get(i).getNameCategory()%></li>
							<%
				}
			%>

						</ul>
					</div>
				</div>
			</div>
			<div class="row featured__filter">
				<%
					int max = 33;
					int numb = products.size();
					DecimalFormat numformat = new DecimalFormat("#,###,###");
					if (numb < max) {
						for (Books ls : productstop8) {
				%>
				<div
					class="col-lg-3 col-md-4 col-sm-6 mix oranges<%=ls.getId_Category()%> ">
					<div class="featured__item">
						<div class="featured__item__pic set-bg"
							data-setbg="viewroot/img/shop/product/<%=ls.getImageDisplay()%>">
							<ul class="featured__item__pic__hover">
								<li><a href="#"><i class="fa fa-heart"></i></a></li>
								<li><a href="#"><i class="fa fa-retweet"></i></a></li>
								<li><a onclick="addProductToCart(<%=ls.getId()%>)"><i
										class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="">
							<h6>
								<a href="HomeProductsDetail?id=<%=ls.getId()%>"><%=ls.getNameBook()%></a>
							</h6>
							<%
								if (ls.getStatus() == 1) {
											if (ls.getDiscount() > 0) {
							%>
							<div class="price-up-down">
								<span class="sale-new">Giảm <%=ls.getDiscount()%>%
								</span>
							</div>
							<%
								}
										} else {
							%>
							<div class="price-up-down">
								<span class="sale-new">Hot </span>
							</div>
							<%
								}
							%>

							<h5>
								<%
										double price = ls.getPriceBook();
												int sale = ls.getDiscount();
												price = price - (price * sale / 100);
												String price_nb = numformat.format(price);
									%>
								<%=price_nb%>đ
							</h5>
						</div>
					</div>
				</div>
				<%
					}
					} else {
						for (int i = 0; i < max; i++) {
				%>
				<div
					class="col-lg-3 col-md-4 col-sm-6 mix oranges<%=products.get(i).getId_Category()%>">
					<div class="featured__item">
						<div class="featured__item__pic set-bg"
							data-setbg="viewroot/img/shop/product/<%=products.get(i).getImageDisplay()%>">
							<ul class="featured__item__pic__hover">
								<li><a href="#"><i class="fa fa-heart"></i></a></li>
								<li><a href="#"><i class="fa fa-retweet"></i></a></li>
								<li><a href="#" onclick="addProductToCart(<%=products.get(i).getId()%>)"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<a href="HomeProductsDetail?id=<%=products.get(i).getId()%>"><%=products.get(i).getImageDisplay()%></a>
							</h6>
							<%
								if (products.get(i).getStatus() == 1) {
											if (products.get(i).getDiscount() > 0) {
							%>
							<span class="sale-new">Giảm <%=products.get(i).getDiscount()%>%
							</span>
						</div>
						<%
								}
										} else {
							%>
						<div class="price-up-down">
							<span class="sale-new">Hết bán </span>
						</div>
						<%
								}
							%>
						<h5>
							<%
										double price = products.get(i).getPriceBook();
												int sale = products.get(i).getDiscount();
												price = price - (price * sale / 100);
												String price_nb = numformat.format(price);
									%>
							<%=price_nb%>
							đ
						</h5>
					</div>
				</div>
			</div>
			<%
					}
					}
				%>
		</div>
		</div>
	</section>
	<!-- Featured Section End -->

	<!-- Banner Begin -->
	<div class="banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="img/banner/banner-1.jpg" alt="">
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="img/banner/banner-2.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner End -->


 
	

	

	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->




</body>

</html>