<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Đăng nhập</title>

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
		data-setbg="viewroot/img/bredbook.jpg">
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
			<div class="row">
				<div class="col-sm-6 border border-success">
					<h3 class="text-center">Đăng Nhập</h3>
					<%
					if (session.getAttribute("SingupSuccess") != null) {
					%>
					<div class="alert alert-success">
						<%=session.getAttribute("SingupSuccess")%>
					</div>
					<%
					session.removeAttribute("SingupSuccess");
					}
					%>

					<form action="UsersLoginServlet" method="post">
						<div class="form-group">
							<label for="email">Tên Tài Khoản</label> <input name="user-name"
								placeholder="Tên tài khoản hoặc email" type="text" required
								class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="pwd">Mật Khẩu</label> <input name="user-password"
								placeholder="Mật khẩu" type="password" class="form-control"
								id="pwd" required>
						</div>
						<%
						if (session.getAttribute("errorlogin") != null) {
						%>
						<div class="alert alert-danger">
							<center><%=session.getAttribute("errorlogin")%></center>
						</div>
						<%
						session.removeAttribute("errorlogin");
						}
						%>
						<button type="submit" class="btn btn-primary text-center">Đăng
							nhập</button>
						<br> <br>

					</form>
					<img alt="" src="viewroot/img/banner/bookbanner.jpg">

				</div>
				<div class="col-sm-6 border border-danger">
					<h3 class="text-center">Đăng Ký</h3>
					<form action="UsersRegisterServlet" method="post">
						<div class="form-group">
							<label for="email">Tên tài khoản</label> <input name="user-name"
								placeholder="Tên tài khoản *" type="text" required
								class="form-control" id="account">

						</div>
						<div class="form-group">
							<label for="pwd">Mật khẩu</label> <input name="user-password"
								placeholder="Mật khẩu *" type="password" required
								class="form-control" id="pwd">

							<div class="form-group">
								<label for="pwd">Nhập lại mật khẩu</label> <input
									name="user-passwordcf" placeholder="Nhập lại mật khẩu *"
									type="password" required class="form-control" id="pwds">

							</div>
							<div class="form-group">
								<label for="pwd">Địa Chỉ email</label> <input name="user-email"
									placeholder="Email *" type="email" required
									class=" form-control" id="pwd">
							</div>
							<div class="form-group">
								<label for="pwd">Tên Người dùng</label> <input
									name="user-showname" placeholder="Tên hiển thị *" type="text"
									required class="form-control" id="pwdss">
							</div>
							<button type="submit" class="btn btn-danger  text-center">Đăng
								ký</button>
					</form>
				</div>
			</div>
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