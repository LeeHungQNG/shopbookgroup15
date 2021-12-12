<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="layout/head.jsp"></jsp:include>

</head>
<body>
	<div id="main-wrapper">
		<!-- Thêm phần tiêu đề trang -->
		<jsp:include page="layout/header.jsp"></jsp:include>
		<!-- Xong phần tiêu đề trang -->
		<div class="content-body">
			<div class="container-fluid">
				<div class="row page-titles mx-0">
					<div class="col-sm-6 p-md-0">
						<div class="welcome-text">
							<h4>XIN	CHÀO MỪNG ĐẾN </h4>
							<p class="mb-1">Validation</p>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">QUAN TRỊ</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">THONG TIN ADMIN</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->
				<div class="row">
					<div class="col-sm-8 offset-1">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Thông tin quản trị viên</h4>
								<div class="alert alert-success"><%=session.getAttribute("mess")%></div>
							</div>
							<div class="card-body">
								<div class="basic-form">
									<form action="AdminProfileController" method="post">
										<div class="form-group">
											<input type="text" class="form-control input-default "
												placeholder="tên đăng nhập" name="username">
										</div>
										<div class="form-group">
											<input type="password" class="form-control input-default "
												placeholder="mật Khẩu cũ" name="pass-old">
										</div>
										<div class="form-group">
											<input type="password" class="form-control input-rounded"
												placeholder="Mật Khẩu mới" name="pass-new">
										</div>
										<div class="form-group">
											<input type="submit"form-control input-default "
												placeholder="" value="Thảy đổi">
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Thêm chân trang -->
		<jsp:include page="layout/footer.jsp"></jsp:include>
		<!-- Xong thêm chân trang -->
	</div>
</body>
</html>
