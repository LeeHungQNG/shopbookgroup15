<%@page import="model.Category"%>
<%@page import="model.BookDetail"%>
<%@page import="model.Books"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title></title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<jsp:include page="layout/head.jsp"></jsp:include>

</head>

<body>
	<%
	Books product = (Books) request.getAttribute("product");
	ArrayList<BookDetail> listproduct = (ArrayList<BookDetail>) request.getAttribute("listDetails");
	%>
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
						<h2>Sản Phẩm</h2>
						<div class="breadcrumb__option">
							<a href="Home">Home</a> <a href="#"><%=product.getNameBook()%></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item--large"
								src="viewroot/img/shop/product/<%=product.getImageDisplay()%>"
								alt="">
						</div>
						<div class="product__details__pic__slider owl-carousel">
							<%
							for (BookDetail pd : listproduct) {
							%>
							<img data-imgbigurl="img/product/details/product-details-2.jpg"
								src="viewroot/img/shop/DetailProduct/<%=pd.getImageLink()%>"
								alt="">
							<%
							}
							%>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h3><%=product.getNameBook()%></h3>
						<div class="product__details__rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star-half-o"></i> <span>(18 Đánh giá)</span>
						</div>
						<div class="product__details__price"><%=product.getPriceBook()%>VND
						</div>
						<p>Mô tả thông tin sách: Lorem ipsum dolor, sit amet consectetur adipisicing elit. At animi veniam eaque consectetur quam maiores natus vero repellendus necessitatibus, repudiandae ea ad dicta nemo. Ducimus autem velit error neque officiis</p>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty">
									<input type="text" value="1">
								</div>
							</div>
						</div>
						<a href="#" onclick="addProductToCart(<%=product.getId()%>)"
							class="primary-btn">Thêm Sản Phẩm</a> <a href="#"
							class="heart-icon"><span class="icon_heart_alt"></span></a>
						<ul>
							<li><b>Trình Trạng</b> <%
							 if (product.getAmount() > 0) {
							 %> <span>Còn Hàng </span> <%} else {%> <span>hết Hàng</span> <%
							 }
							 %></li>

							<li><b>Giao Hàng</b> <span>Trong vòng 24h <samp>Miễn
										phí Nội Thành </samp></span></li>
							<li><b>Giảm Giá</b> <span><%=product.getDiscount()%></span></li>
							<li><b>Chịa sẻ</b>
								<div class="share">
									<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
										class="fa fa-twitter"></i></a> <a href="#"><i
										class="fa fa-instagram"></i></a> <a href="#"><i
										class="fa fa-pinterest"></i></a>
								</div></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="product__details__tab">
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Mô
									Tả</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-2" role="tab" aria-selected="false">Phòng cách</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-3" role="tab" aria-selected="false">Phương pháp
									Bảo quản <span>(1)</span>
							</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tabs-1" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Mô Tả sản phẩm</h6>
									<p>
										<%=product.getDescription()%>
									</p>
								</div>
							</div>
							<div class="tab-pane" id="tabs-2" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Chưa cập nhâp</h6>

								</div>
							</div>
							<div class="tab-pane" id="tabs-3" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Phương Pháp Bảo Quản</h6>
									<p>Dọn sạch bụi. Bao bìa cho sách. Sắp xếp gọn gàng sau khi
										sử dụng. Chọn giá, kệ phù hợp. Cất giữ sách ở nơi khô ráo.
										Dùng bookmark để đánh dấu trang. Sử dụng gói hút ẩm.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Details Section End -->

	<!-- Related Product Section Begin -->
	<section class="related-product">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title related__product__title">
						<h2>Sản phẩm gần giống</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<%
				ArrayList<Books> list = (ArrayList<Books>) request.getAttribute("listp");
				for (int i = 0; i < 4; i++) {
				%>
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="product__item">
						<div class="product__item__pic set-bg"
							data-setbg="viewroot/img/shop/product/<%=list.get(i).getImageDisplay()%>">
							<ul class="product__item__pic__hover">
								<li><a href="#"><i class="fa fa-heart"></i></a></li>
								<li><a href="#"><i class="fa fa-retweet"></i></a></li>
								<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="#"><%=list.get(i).getNameBook()%></a>
							</h6>
							<h5><%=list.get(i).getPriceBook()%></h5>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</section>
	<!-- Related Product Section End -->

	<!-- Footer Section Begin -->
	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->

</body>

</html>