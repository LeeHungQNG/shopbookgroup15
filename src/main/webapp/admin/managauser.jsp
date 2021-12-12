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
							<h4>Xin chào bạn</h4>
							<span class="ml-1">Tài khoản</span>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Quản trị</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">Quản lý tài khoản</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->


				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">QUẢN LÝ TÀI KHOẢN</h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table id="datatable-user" class="display" style="width: 100% ;color:black;">
										<thead>
											<tr>
												<th>STT</th>
												<th>tên Tài khoản</th>
												<th>Email</th>
												<th>Phần quyền</th>
												<th>Địa chỉ</th>
												<th>Giới tính</th>
												<th>Ngày Sinh</th>
												<th>#</th>
												<th>#</th>
											
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

	</div>
		<script type="text/javascript">
		var json =<%=request.getAttribute("jsonUser")%>;
		$('#datatable-user')
				.DataTable(
						{
							data : json,
							columns : [
									{
										data : 'id'
									},
									{
										data : 'nameDisplay'
									},
									{
										data : 'email'
									},
									{
										data : 'role',
										render : function(data) {
											if (data == "ADMIN") {
												return "<button type='button'  class='btn btn-sm btn-primary'>Admin</button>"
											} else {
												return "<button type='button' class='btn btn-sm btn-danger'>User</button>"

											}
										}
									},
									{
										data : 'address'
									},
									{
										data : 'sex'
									},
									{
										data : 'datebirth'
									},
									{
										data : 'id',
										render : function(data) {
											return "<button type='button' onclick='changeRole("
													+ data
													+ ")' class='btn btn-primary'>Phần quyền</button>"
										}
									},
									{
										data : 'id',
										render : function(data) {
											return "<button type='button' class='btn btn-primary' onclick='deleteUser("
													+ data + ")'>Xóa</button>"
										}
									}, ],
							"pageLength" : 15
						});
		function deleteUser(id) {
			if (confirm("Bạn muốn xóa tài khoản này"))
				$.ajax({
					url : "AdminDeleteUser?id=" + id,
					type : 'POST',
					success : function(reponse) {
						console.log(reponse);
						alert("Đã xóa thành công ");
						window.location.href = "AdminManagaUserController";
					}

				})
		}
		// dung ajax de phan quyen dung k
		function changeRole(id) {
			if (confirm("Bạn muốn thảy đổi quyền user"))
				$.ajax({
					url : "AdminChangeRoleController?id=" + id,
					type : 'POST',
					success : function(reponse) {
						console.log(reponse);
						alert("Đã thảy đổi thành công ");
						window.location.href = "AdminManagaUserController";
					}
				})

		}
	</script>
	
</body>
</html>