<%@page import="model.Books"%>
<%@page import="model.Cart"%>

<%@page import="java.util.Map"%>
<%@page import="dao.CartDAO"%>
<%@ page pageEncoding="utf-8"%>
<%@page import="java.util.Map.Entry"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Cart</title>

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
		
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<table>
							<thead>
								<tr>
									<th class="product-price">Hình ảnh</th>
									<th class="product-name">Tên sản phẩm</th>
									<th class="product-price">Giá</th>
									<th class="product-quantity">Số lượng</th>
									<th class="product-subtotal">Thành tiền</th>
									<th class="product-name">Xóa bỏ</th>
									<th>Cập nhật</th>
								</tr>
							</thead>
							<tbody>
								<% int i=0;
										Map<Books,Integer> cartMap = (Map<Books,Integer>) session.getAttribute("shoppingcart");
								if(cartMap!=null){
                            	for(Map.Entry<Books, Integer> entry : cartMap.entrySet()){
                            		
		
									%>
									<form onsubmit="return checkAmount(<%=entry.getValue()%>,<%=i%>)"  action="CartControllerServlet?key=add" method="get">
								<tr>
								<input hidden="hidden" value="<%=entry.getKey().getId()%>" name="id">
								<input hidden="hidden" value="<%=entry.getValue()%>" name="amounts">
								
									<td class="shoping__cart__item"><a href="#"><img
											style="width: 40%;"
											src="viewroot/img/shop/product/<%=entry.getKey().getImageDisplay()%>"
											alt=""></a></td>
									<td class="shoping__cart__item"><a href="#"><%=entry.getKey().getNameBook()%></a></td>

									<td class="shoping__cart__price"><span class="amount"><%=entry.getKey().getPriceBook()*entry.getValue()%>
											đ</span></td>
									<td class="shoping__cart__quantity"><input  name="number-product"
										value="<%=entry.getValue()%>" type="number" min="1"
										maxlength="4" ></td>

									<td class="shoping__cart__total"><%=entry.getKey().getPriceBook()*entry.getValue()%>
										đ</td>
									<td class="shoping__cart__item__close"><a
										href="CartControllerServlet?key=remove&id=<%=entry.getKey().getId()%>&number-product=<%=entry.getValue()-1%>"
										title="xóa bỏ chọn hàng"><i class="fa fa-times"></i></a></td>
										<td> <button type="submit"  class="btn btn-primary"><i class="fa fa-upload" > </i></button></td>
								</tr>
								</form>
								<%
								i++;
								}
										} else {
									%>
								<tr>
									<div class="alert alert-info">
										<center>
											<strong>Giỏ hàng trống!</strong>
										</center>
									</div>
								</tr>
								<%
										}
									%>
								<!-- in ra thông báo đặt hàng thành công -->
								<%if(session.getAttribute("paid")!=null){
										%>
								<tr>
									<div class="alert alert-success">
										<center>
											<%out.print(session.getAttribute("paid")); %>
											<!-- <strong>Đặt hàng thành công, mời bạn click vào <a href="HomeProductsServlet"><span style="color:blue">đây</span></a> để tiếp tục mua sắm!</strong> -->
										</center>
									</div>
								</tr>
								<%session.removeAttribute("paid"); %>
								<!-- /in ra thông báo đặt hàng thành công -->
								<%}//session.removeAttribute("paid");x%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__btns">
						<a href="Home" class="primary-btn cart-btn">Tiếp Tục Mua sắm</a> 
					</div>
				</div>
			
				<div class="col-lg-6">
					<div class="shoping__continue">
						<div class="shoping__discount">
							<h5>Mã Giảm Giá</h5>
							<form action="#">
								<input type="text" placeholder="Enter your coupon code">
								<button type="submit" class="site-btn">Áp Dụng</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="shoping__checkout">
						<h5>Cart Total</h5>
						<ul>
							<%Cart cart =(Cart)session.getAttribute("cart");
 %>
							<li>Số Lượng <span><%=cart.getAmount()%></span></li>
							<li>Tổng tiền <span><%=cart.getTotalPrice()%> đ</span></li>
						</ul>
						<%
								if (cart.getAmount() > 0) {
							%>
						<a href="checkout.jsp" class="primary-btn">Xử lý Thành thành
							toán</a>
						<%} %>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Shoping Cart Section End -->

	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<script type="text/javascript">
	//kiêm tra số lượng có được thảy dổi không vi du 1 không xuống 0 được
	function checkAmount(quantity,point){
		var amount=0;
		var i=0;
		$("input[name='number-product']").each(function() {
			if(i==point){
				amount = $(this).val();
			}
			i++;
		});
		console.log(amount);
		console.log(quantity);
		if(amount==quantity){
			alert("Số lượng không thay đổi bạn vui lòng kiểm tra lại!")
			return false
		}else if(amount>0) {
			return true;
		}
	}

	</script>
	<!-- Xong thêm chân trang -->
</body>

</html>