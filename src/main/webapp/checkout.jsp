<%@page import="model.Province"%>
<%@page import="bo.AddressBO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Users"%>
<%@page import="model.Books"%>
<%@page import="model.Cart"%>
<%@page import="java.util.Map"%>
<%@page import="dao.CartDAO"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.Map.Entry"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Checkout</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<jsp:include page="layout/head.jsp"></jsp:include>
</head>
<body>

	<!-- Page Preloder -->
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
						<h2>Giỏ hàng</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Home</a> <span>Giỏ Hàng</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
		<div class="container">
			<div class="py-5 text-center">
				<img class="d-block mx-auto mb-4" src="viewroot/img/logo.png" alt=""
					width="72" height="72">
				<h2>Thanh Toán</h2>

			</div>

			<div class="row">
				<div class="col-md-4 order-md-2 mb-4">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Sản Phẩm </span> <span
							class="badge badge-secondary badge-pill">3</span>
					</h4>
					<ul class="list-group mb-3">
						<%
						Cart cart = (Cart) session.getAttribute("cart");
						Map<Books, Integer> cartMap = (Map<Books, Integer>) session.getAttribute("shoppingcart");
						if (cartMap != null) {
							for (Map.Entry<Books, Integer> entry : cartMap.entrySet()) {
						%>

						<li
							class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0"><%=entry.getKey().getNameBook()%></h6>
							</div> <span class="text-muted"><%=entry.getValue() * entry.getKey().getPriceBook()%>
								đ</span>
						</li>
						<%
						}
						%>
						<li class="list-group-item d-flex justify-content-between"><span>Total
								(VND)</span> <strong><%=cart.getTotalPrice()%></strong></li>
					</ul>

					<form class="card p-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Promo code">
							<div class="input-group-append">
								<button type="submit" class="btn btn-secondary">Mã Giảm
									Giá</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-8 order-md-1">
					<h4 class="mb-3">Thông tin Nhận Hàng</h4>
					<form class="needs-validation" method="post"
						action="HomeBillServlet?status=addbill">
						<div class="row">
							<div class="col-md-12">
								<label for="firstName">Họ tên</label>
								<%
								if (session.getAttribute("uslogin") != null) {
									// Giá trị session tồn tại 2 giờ
									session.setMaxInactiveInterval(2 * 60 * 60);
									Users us = (Users) session.getAttribute("uslogin");
								%>
								<input class="form-control" placeholder="" type="text"
									value="<%=us.getNameDisplay()%>" required name="user-name">
								<%
								} else {
								%>
								<input class="form-control" placeholder="" type="text"
									name="user-name" required>
								<%
								}
								%>
							</div>
						</div>

						<div class="mb-3">
							<label for="username">Tên Người nhận</label>
							<div class="input-group">
								<input type="text" class="form-control" id="username"
									placeholder="Username" name="user-name" required="">
								<div class="invalid-feedback" style="width: 100%;">Người
									nhận hàng</div>
							</div>
						</div>

						<div class="mb-3">
							<label for="country">Thành Phố/Tỉnh </label> <select
								class="custom-select d-block w-100" name="country"
								onchange="loadDistrict(this.value);" id="country" required="">
								<%
								AddressBO addressBO = new AddressBO();
								for (Province list : addressBO.getListProvince()) {
								%>
								<option value="<%=list.getProvinceid()%>" title="<%=list.getName()%>"><%=list.getName()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label for="country">Quận/Huyện</label>
							<div id="district">
								<select class="custom-select d-block w-100" id="country"
									required="">
									<option value="">Choose...</option>
								</select>
							</div>
						</div>
						<div class="mb-3">
							<label for="country">xã/Phường</label>
							<div id="town_ward">
								<select class="custom-select d-block w-100" id="country"
									required="">
									<option value="">Choose...</option>
								</select>
							</div>
						</div>
						<div class="mb-3">
							<label for="country">thôn/tổ</label>
							<div id="village">
								<select class="custom-select d-block w-100" id="country"
									required="">
									<option value="">Choose...</option>
								</select>
							</div>
						</div>
						<div class="mb-3">
							<label for="address">Số Nhà</label> <input type="text"
								class="form-control" id="address" name="address"
								placeholder="số nhà/" required="">
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label for="address2">Số Điện Thoại<span
									class="text-muted"></span></label> <input type="text"
									class="form-control" id="address2" placeholder="Số điện thoại"
									name="phone" onkeypress="return keyPhone(event);">
							</div>
							<div class="col-sm-6">
								<label for="address2">Email<span class="text-muted"></span></label>
								<input type="text" class="form-control" id="address2"
									placeholder="Nhập địa chỉ email" name="email">
							</div>
						</div>

						<div class="mb-3">
							<label for="address">Ghi Chú</label>
							<textarea type="text" class="form-control" id="address"
								placeholder="ghi chú đơn hàng" name="note" required=""></textarea>

						</div>
						<hr class="mb-4">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="same-address"> <label class="custom-control-label"
								for="same-address">Đồng ý với địa chỉ nhận hàng</label>
						</div>
						<hr class="mb-4">

						<h4 class="mb-3">Hình Thức thành toán</h4>

						<div class="d-block my-3">
							<div class="custom-control custom-radio">
								<input id="credit" name="paymentMethod" type="radio"
									class="custom-control-input" checked="" required=""> <label
									class="custom-control-label" for="credit">Thành Toán
									khi nhận hàng</label>
							</div>
							<div class="custom-control custom-radio">
								<input id="debit" name="paymentMethod" type="radio"
									class="custom-control-input" required=""> <label
									class="custom-control-label" for="debit">Thành toán
									online</label>
							</div>
							<div class="custom-control custom-radio">
								<input id="paypal" name="paymentMethod" type="radio"
									class="custom-control-input" required=""> <label
									class="custom-control-label" for="paypal">Thành toán
									thẻ ghi nợ</label>
							</div>
						</div>
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" onsubmit="orderBook()" type="submit">Thanh
							Toán</button>
					</form>
				</div>
				<%
				if (cart == null) {
					//if(session.getAttribute("paid") != null){
				%>
				<div class="alert alert-info">
					<center>
						<strong>Giỏ hàng trống! Mời bạn tiếp tục mua sắm.</strong> <strong>
							<%
							out.print("Đặt hàng thành công, mời bạn tiếp tục mua sắm!");
							%>
						</strong>
					</center>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</section>
	<!-- Shoping Cart Section End -->
	<%
	} else {
	}
	%>
	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->

</body>

</html>