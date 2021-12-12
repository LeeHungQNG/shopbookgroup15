<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Liện Hệ</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

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
		data-setbg="viewroot/img/breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Đăng Nhập/Đăng Ký</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Home</a> <span>Đăng Nhập/Đăng Ký</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->
	<!-- Contact Form Begin -->
	<div class="contact-form spad">
		<div class="container ">
			<h1 style="text-algin: center"><%=request.getAttribute("codeError") %></h1>
			<h4 style="text-algin: center"><%=request.getAttribute("error") %></h4>

		</div>

	</div>
	</div>

	</div>
	<!-- Contact Form End -->

	<!-- Footer Section Begin -->
	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->




</body>

</html>