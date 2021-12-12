<%@page import="model.Users"%>
<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Account</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<jsp:include page="layout/head.jsp"></jsp:include>
</head>
<body>
<% 
Users user = (Users) session.getAttribute("uslogin");
%>
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
						<h2>Thông Tin Tài Khoản</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Home</a> <span>Thông Tin Tài Khoản</span>
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
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Thông tin Tài khoản</h4>
						</div>
						<div class="card-body">
							<div class="form-validation">
								<form class="form-valide" action="HomeProfileServlet" method="post"
									novalidate="novalidate">
									<div class="row">
										<div class="col-xl-6">
											<div class="form-group row">
												<label class="col-lg-4 col-form-label" for="val-username">Tên
													Đăng Nhập <span class="text-danger">*</span>
												</label>
												<div class="col-lg-6">
													<input type="text" class="form-control" id="val-username"
														name="val-username" value="<%=user.getUsername() %>" placeholder="">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-4 col-form-label" for="val-date">Ngày
													sinh<span class="text-danger">*</span>
												</label>
												<div class="col-lg-6">
													<input type="text" class="form-control" id="val-email"
														name="val-date"  value="<%=user.getDatebirth() %>" placeholder="Nhập ngày sinh (16/12/2022)">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-4 col-form-label" for="val-address">Địa
													chỉ <span class="text-danger">*</span>
												</label>
												<div class="col-lg-6">
													<input type="text" class="form-control valid"
														id="val-password" name="val-address"
														placeholder="Choose a safe one.."
														aria-describedby="val-password-error" value="<%=user.getAddress() %>" aria-invalid="false">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-4 col-form-label"
													for="sex">Giới tính<span
													class="text-danger">*</span>
												</label>
												<div class="col-lg-6">
													<input type="checkbox"  value="<%=user.getSex() %>" 
														id="" name="sex"
														placeholder="Nam">  nam
														<input type="checkbox"  value="<%=user.getSex() %>" 
														id="" name="sex"
														placeholder="Nam">  nữ
												</div>
											</div>
										</div>
										<div class="col-xl-6">
											<div class="form-group row">
												<label class="col-lg-4 col-form-label" for="user-name">Tên
													Tài Khoản<span class="text-danger">*</span>
												</label>
												<div class="col-lg-6">
													<input type="text" value="<%=user.getNameDisplay() %>" class="form-control" id="val-currency"
														name="user-name" placeholder="">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-4 col-form-label" for="user-email">Email
													<span class="text-danger">*</span>
												</label>
												<div class="col-lg-6">
													<input type="text" value="<%=user.getEmail() %>" class="form-control" id="val-website"
														name="user-email">
												</div>
											</div>
											<div class="form-group row">
												<div class="col-lg-8 ml-auto">
													<button type="submit" class="btn btn-primary">Cập
														nhật thông tin</button>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Thảy đổi Mật Khẩu</h4>
					</div>
					<%
								if (session.getAttribute("error") != null) {
							%>
					<div class="alert alert-success">
						<%=session.getAttribute("error")%>
					</div>
					<%
								session.removeAttribute("error");
								}
							%>
					<div class="card-body">
						<div class="form-validation">
							<form class="form-valide" action="HomeProfileServlet" method="post"
								novalidate="novalidate">
								<div class="row">
									<div class="col-xl-12">
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="pass-old">
												Mật khẩu cũ <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="password" class="form-control" id="val-username"
													name="pass-old" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="pass_new"">Mật
												khẩu mới<span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="password" class="form-control" id="pass-new"
													name="pass_new" placeholder="Nhập phòng cách">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="pass-confirm">Nhập
												lại mật khẩu <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="password" class="form-control valid"
													id="val-password" name="pass-confirm"
													placeholder="Choose a safe one.."
													aria-describedby="val-password-error" aria-invalid="false">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg-8 ml-auto">
												<button type="submit"  onclick="updatepass()" class="btn btn-primary">Thảy đổi mật khẩu</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- Shoping Cart Section End -->

	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->

</body>

</html>