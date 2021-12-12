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
							<span class="ml-1">Danh Mục</span>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Quản trị</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">Quản lý danh mục</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->


				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<div class="">
									<a href="javascript:void()" data-toggle="modal"
										data-target="#add-category"
										class="btn btn-primary btn-event w-100"> <span
										class="align-middle"><i class="ti-plus"></i></span> Thêm Danh
										Mục
									</a>
								</div>
							</div>
							<div class="modal fade none-border" id="add-category">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">
												<strong>Thêm Danh Mục</strong>
											</h4>
										</div>
										<form action="AdminManagaCategoryController" method="post">

											<div class="modal-body">
												<div class="row">
													<div class="col-md-8">
														<label class="control-label">Tên Danh Mục</label> <input
															class="form-control form-white" placeholder=""
															type="text" name="val-category">
													</div>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default waves-effect"
													data-dismiss="modal">Đóng</button>
												<button type="submit"
													class="btn btn-danger waves-effect waves-light save-category">Thêm</button>
											</div>
										</form>

									</div>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="datatable-category" class="display"
									style="width: 100%; color: black;">
									<thead>
										<tr>
											<th>STT</th>
											<th>Thể Loại</th>
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
		var json =
	<%=request.getAttribute("jsonCategory")%>
		;
		$('#datatable-category')
				.DataTable(
						{
							data : json,
							columns : [
									{
										data : 'id'
									},
									{
										data : 'nameCategory'
									},
									{
										data : 'id',
										render : function(data) {
											return "<button type='button' class='btn btn-sm btn-primary' onclick='deleteCategory("
													+ data + ")'>Xóa</button>"
										}
									}, ],
							"pageLength" : 15
						});
		function deleteCategory(id) {
			if(id<13){
				alert("Bạn không thế xóa ");
				return false;
			}
			if (confirm("Bạn muốn xóa thể loại này"))
				$.ajax({
					url : "AdminDeleteCategory?id=" + id,
					type : 'POST',
					success : function(reponse) {
						console.log(reponse);
						alert("Đã xóa thành công ");
						window.location.href = "AdminManagaCategoryController";
					}

				})
		}
	</script>
	
</body>
</html>