<%@page import="java.util.List"%>
<%@page import="bo.BookBO"%>
<%@page import="model.Books"%>
<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
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
<title>Sản Phẩm</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<jsp:include page="layout/head.jsp"></jsp:include>

</head>

<body>
	<!-- Thêm phần tiêu đề trang -->
	<jsp:include page="layout/header.jsp"></jsp:include>
	<!-- Xong phần tiêu đề trang -->
	<!-- Hero Section Begin -->
	<jsp:include page="layout/hero-nomar.jsp"></jsp:include>

	<!-- Hero Section End -->

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg"
		data-setbg="viewroot/img/bredbook.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>TGM Shop</h2>
						<div class="breadcrumb__option">
							<a href="Home">Home</a> <span>Shop</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-5">
					<div class="sidebar">
						<div class="sidebar__item">
							<h4>Dành Mục Sản Phẩm</h4>
							<ul>
								<%
								ArrayList<Category> category = (ArrayList<Category>) request.getAttribute("lstCategory");
								for (Category ls : category) {
								%>
								<li><input type="checkbox"> <a
									href="HomeProductsServlet?id_category=<%=ls.getId()%>"><%=ls.getNameCategory()%></a></li>
								<%
								}
								%>
							</ul>
						</div>
						<div class="sidebar__item">
							<h4>Giá Cả</h4>
							<div class="price-range-wrap">
								<div
									class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
									data-min="10" data-max="540">
									<div class="ui-slider-range ui-corner-all ui-widget-header"></div>
									<span tabindex="0"
										class="ui-slider-handle ui-corner-all ui-state-default"></span>
									<span tabindex="0"
										class="ui-slider-handle ui-corner-all ui-state-default"></span>
								</div>
								<div class="range-slider">
									<div class="price-input">
										<input type="text" id="minamount"> <input type="text"
											id="maxamount">
									</div>
								</div>
							</div>
						</div>
						<div class="sidebar__item sidebar__item__color--option">
							<h4>Colors</h4>
							<div class="sidebar__item__color sidebar__item__color--white">
								<label for="white"> Trắng <input type="radio" id="white">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--gray">
								<label for="gray"> Lam <input type="radio" id="gray">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--red">
								<label for="red"> ĐỎ <input type="radio" id="red">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--black">
								<label for="black"> Đen <input type="radio" id="black">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--blue">
								<label for="blue"> Xanh <input type="radio" id="blue">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--green">
								<label for="green"> Vàng <input type="radio" id="green">
								</label>
							</div>
						</div>
						<div class="sidebar__item">
							<h4>Popular Size</h4>
							<div class="sidebar__item__size">
								<label for="large"> size lớn <input type="radio"
									id="large">
								</label>
							</div>
							<div class="sidebar__item__size">
								<label for="medium"> size vừa <input type="radio"
									id="medium">
								</label>
							</div>
							<div class="sidebar__item__size">
								<label for="small"> size nhỏ <input type="radio"
									id="small">
								</label>
							</div>
							<div class="sidebar__item__size">
								<label for="tiny"> Combo <input type="radio" id="tiny">
								</label>
							</div>
						</div>
						<div class="sidebar__item">
							<div class="latest-product__text">
								<h4>Sản Phẩm Mới</h4>
								<div class="latest-product__slider owl-carousel">
									<%
									ArrayList<Books> products = (ArrayList<Books>) request.getAttribute("lstProducts");

									for (int i = 0; i < 2; i++) {
										if (i == 0) {
									%>

									<div class="latest-prdouct__slider__item">
										<%
										int count = 0;
										for (Books ls : products) {
											if (count < 4 && ls.getId_Category() == 7) {
												count++;
										%>
										<a href="#" class="latest-product__item">
											<div class="latest-product__item__pic">
												<img src="viewroot/img/shop/product/<%=ls.getImageDisplay()%>"
													alt="">
											</div>
											<div class="latest-product__item__text">
												<h6><%=ls.getNameBook()%>"
												</h6>
												<span><%=ls.getPriceBook()%>"</span>
											</div>
										</a>
										<%
										}
										}
										%>
									</div>
									<%
									} else {
									%>

									<div class="latest-prdouct__slider__item">

										<%
										int count = 0;
										for (Books ls : products) {
											if (count < 4 && ls.getId_Category() == 7) {
												count++;
										%>
										<a href="#" class="latest-product__item">
											<div class="latest-product__item__pic">
												<img src="viewroot/img/shop/product/<%=ls.getImageDisplay()%>"
													alt="">
											</div>
											<div class="latest-product__item__text">
												<h6><%=ls.getNameBook()%>"
												</h6>
												<span><%=ls.getPriceBook()%>"</span>
											</div>
										</a>
										<%
										}
										}
										%>
									</div>
									<%
									}
									}
									%>
								</div>

							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-9 col-md-7">
					<div class="product__discount">
						<div class="section-title product__discount__title">
							<h2>Khuyến Mại</h2>
						</div>
						<div class="row">
							<div class="product__discount__slider owl-carousel">
								<%
								DecimalFormat numformatx = new DecimalFormat("#,###,###");
								//Lấy ra danh sách sản phẩm
								//ArrayList<Products> list = s.getAllProDuctsLimit(first, last);
								ArrayList<Books> lists = (ArrayList<Books>) request.getAttribute("lstProducts");

								for (Books ls : lists) {
									if (ls.getDiscount() >0) {
								%>
								<div class="col-lg-4">
									<div class="product__discount__item">
										<div class="product__discount__item__pic set-bg"
											data-setbg="viewroot/img/shop/product/<%=ls.getImageDisplay()%>">
											<div class="product__discount__percent"><%=ls.getDiscount()%></div>
											<ul class="product__item__pic__hover">
												<li><a href="#"><i class="fa fa-heart"></i></a></li>
												<li><a href="#"><i class="fa fa-retweet"></i></a></li>
												<li><a href="#" onclick="addProductToCart(<%=ls.getId()%>)"><i class="fa fa-shopping-cart"></i></a></li>
											</ul>
										</div>
										<div class="product__discount__item__text">
											<span></span>
											<h5>
												<a href="HomeProductsDetail?id=<%=ls.getId()%>"><%=ls.getNameBook()%></a>
											</h5>
											<div class="product__item__price">
												<%=ls.getPriceBook()%>
											</div>
										</div>
									</div>
								</div>
								<%
								}
								}
								%>
							</div>
						</div>
					</div>
					<div class="filter__item">
						<div class="row">
							<div class="col-lg-4 col-md-5">
								<div class="filter__sort">
									<span>Sort By</span> <select>
										<option value="0">Default</option>
										<option value="0">Default</option>
									</select>
								</div>
							</div>
							<div class="col-lg-4 col-md-4">
								<div class="filter__found">
									<h6>
										<span>16</span> Products found
									</h6>
								</div>
							</div>
							<div class="col-lg-4 col-md-3">
								<div class="filter__option">
									<span class="icon_grid-2x2"></span> <span class="icon_ul"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<%
						DecimalFormat numformat = new DecimalFormat("#,###,###");
						//Lấy ra danh sách sản phẩm
						ArrayList<Books> list = (ArrayList<Books>) request.getAttribute("listbooks");

						for (Books ls : list) {
						%>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="viewroot/img/shop/product/<%=ls.getImageDisplay()%>">
									<ul class="product__item__pic__hover">
										<li><a href="#"><i class="fa fa-heart"></i></a></li>
										<li><a href="#"><i class="fa fa-retweet"></i></a></li>
										<li><a href="#" onclick="addProductToCart(<%=ls.getId()%>)"><i class="fa fa-shopping-cart"></i></a></li>
									</ul>
								</div>
								<div class="product__item__text">
									<h6>
										<a  href="HomeProductsDetail?id=<%=ls.getId()%>"><%=ls.getNameBook()%></a>
									</h6>
									<p><%=ls.getDiscount()%>%</p>
									<%
									double price = ls.getPriceBook();
									int sale = ls.getDiscount();
									price = price - (price * sale / 100);
									String price_nb = numformat.format(price);
									%>
									<h5><%=price_nb%>
										đ
									</h5>
								</div>
							</div>
						</div>
						<%
						}
						%>
					</div>
					<div class="product__pagination">
						<%
						ArrayList<Integer> pages = (ArrayList<Integer>) request.getAttribute("page");
						for (int number :pages){
							
						%>
						<a href="HomeProductsServlet?page=<%=number%>"><%=number%></a> 
							<%} %>
							 <i
							class="fa fa-long-arrow-right"></i>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Section End -->

	<!-- Footer Section Begin -->
	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->

</body>

</html>