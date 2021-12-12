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
							<span class="ml-1">Thương Hiệu</span>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Quản trị</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">Quản lý Thương hiệu</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->

Giới Thiệu Tác Giả
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<div class="">
									<a href="javascript:void()" data-toggle="modal"
										data-target="#add-brand"
										class="btn btn-primary btn-event w-100"> <span
										class="align-middle"><i class="ti-plus"></i></span> Thêm
								Tác Giả
									</a>
								</div>
							</div>
							<div class="modal fade none-border" id="add-brand">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">
												<strong>Thêm Tác Giả</strong>
											</h4>
										</div>
										<form action="AdminMangageAuthorController" method="post" enctype="application/x-www-form-urlencoded">
											<div class="modal-body">
												<div class="row">
													<div class="col-md-8">
														<label class="control-label">Tên Tác Giả</label> <input
															class="form-control form-white" placeholder=""
															type="text" name="val-brand">
													</div>
													<div class="col-lg-8">
													<label class="control-label">Giới Thiệu Tác Giả</label>
														<textarea class="form-control" id="val-suggestions"
															name="val-description" rows="5"
															placeholder="Giới thiệu về tác giả" ></textarea>
													</div>
												</div>
												
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default waves-effect"
													data-dismiss="modal">Đóng</button>
												<button type="submit"
													class="btn btn-danger waves-effect waves-light save-category"
													 onclick="AddBrand()">Thêm Tác Giả</button>
											</div>
										</form>
									</div>
								</div>
							</div>

						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="datatable-brand" class="display"
									style="width: 100%; color: black;">
									<thead>
										<tr>
											<th>STT</th>
											<th>Tên Tác Giả</th>
											<th>Giới Thiệu Tác Giả</th>
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
	<script type="text/javascript">
		var json =
	<%=request.getAttribute("jsonBrand")%>
		;
		$('#datatable-brand')
				.DataTable(
						{
							data : json,
							columns : [
									{
										data : 'id'
									},
									{
										data : 'nameAuthor'
									},
									{
										data : 'description'
									},
									{
										data : 'id',
										render : function(data) {
											return "<button type='button' class='btn btn-sm btn-primary' onclick='deleteAuthor("
													+ data + ")'>Xóa</button>"
										}
									}, ],
							"pageLength" : 15
						});
		function deleteAuthor(id) {
			if (confirm("Bạn muốn xóa Tác giả  này"))
				$.ajax({
					url : "AdminAuthorController?id=" + id,
					type : 'POST',
					success : function(reponse) {
						console.log(reponse);
						alert("Đã xóa thành công ");
						window.location.href = "AdminMangageAuthorController";
					}

				})
		}
	</script>

	</div>
</body>
</html>