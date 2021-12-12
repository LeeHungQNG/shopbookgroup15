<%@ page import="java.util.ArrayList"%>
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
							<h4>Xin Chào Mừng </h4>
							<p class="mb-0">Thông kế</p>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Quản trị</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">Thống kế</a></li>
						</ol>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-3 col-sm-6">
						<div class="card">
							<div class="stat-widget-one card-body">
								<div class="stat-icon d-inline-block">
									<i class="ti-money text-success border-success"></i>
								</div>
								<div class="stat-content d-inline-block">
									<div class="stat-text">Doanh Thu(VND)</div>
									<div class="stat-digit"><%=(double)request.getAttribute("revenue") %></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="card">
							<div class="stat-widget-one card-body">
								<div class="stat-icon d-inline-block">
									<i class="ti-user text-primary border-primary"></i>
								</div>
								<div class="stat-content d-inline-block">
									<div class="stat-text">Khách hàng</div>
									<div class="stat-digit"><%=(int)request.getAttribute("amountU") %>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="card">
							<div class="stat-widget-one card-body">
								<div class="stat-icon d-inline-block">
									<i class="ti-layout-grid2 text-pink border-pink"></i>
								</div>
								<div class="stat-content d-inline-block">
									<div class="stat-text">Sản Phẩm</div>
									<div class="stat-digit"><%=(int)request.getAttribute("amountP") %></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="card">
							<div class="stat-widget-one card-body">
								<div class="stat-icon d-inline-block">
									<i class="ti-link text-danger border-danger"></i>
								</div>
								<div class="stat-content d-inline-block">
									<div class="stat-text">Đơn hành vận chuyền</div>
									<div class="stat-digit"><%=(int)request.getAttribute("trans")%></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-8">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Biều đồ thông kê</h4>
							</div>
							<div class="card-body">
								<div class="ct-bar-chart mt-5"></div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<div class="card-body">
								<div class="ct-pie-chart"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Thông kế Doanh Thu</h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<div class="row">
										<div class="col-md-12">
											<div class="card">
												<div class="card-header">
													<strong>KHOẢNG THỜI GIAN</strong>
												</div>
												<div class="card-body card-block">
													<form action="AdminController" method="post"
														enctype="application/x-www-form-urlencoded"
														class="form-horizontal">
														<div class="row">
															<div class="col-md-2"></div>
															<div class="col-md-3">
																<div class="form-group">
																	<label class="form-control-label">Từ ngày</label> <input
																		type="date" placeholder="Chọn ngày"
																		class="form-control" name="sdate" id="tungay"
																		value="" required>
																</div>
															</div>

															<div class="col-md-3">
																<div class="form-group">
																	<label class="form-control-label">Đến ngày</label> <input
																		type="date" placeholder="Chọn ngày"
																		class="form-control" name="enddate"
																		required="required" id="denngay" value="">
																</div>
															</div>
															<div class="col-md-2">
																<div class="form-actions form-group">
																	<button type="submit"
																		class="btn btn-success form-control mt-4"
																		>Thống kê</button>
																</div>
															</div>
														</div>
													</form>
												</div>
											</div>
										</div>
										<div class="col-md-12">
										<h4>Doanh Thu:<%=(double)request.getAttribute("doanhthu")%></h4>
										</div>

									</div>
									<table id="datatable-dashbroad" class="display"
										style="width: 100%; color: black; font-size: 13px;">
										<thead>
											<tr>
												<th>stt</th>
												<th>Người nhận</th>
												<th>Địa chỉ</th>
												<th>Thành phố</th>
												<th>SDT</th>
												<th>Email</th>
												<th>Ghi chú</th>
												<th>Thời gian</th>
												<th>Tổng tiền</th>
											</tr>
										</thead>
									</table>

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
<script type="text/javascript">
//dung jquerry datatable load data
var json =
	<%=request.getAttribute("jsonDashbroad")%>;
		$('#datatable-dashbroad')
				.DataTable(
						{
							data : json,
							columns : [
								{
									data : 'id'
								},
								{
									data : 'nameRecevie'
								},
								{
									data : 'numberHouse'
								},
								{
									data : 'address'
								},
								{
									data : 'numberPhone'
								},
								{
									data : 'email'
								},
								{
									data : 'note'
								},
								{
									data : 'datePay'
								},
								{
									data : 'total'
								},
									
							],
							"pageLength" : 15
						});
</script>
	</div>
</body>
</html>