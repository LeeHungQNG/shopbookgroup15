<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Books"%>
<%@page import="java.util.List"%>
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
							<span class="ml-1">Chi tiết Sách</span>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Quản
									trị</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">chi tiết sản phẩm</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<form action="AdminBookDetailsController" method="post"
									enctype="multipart/form-data" class="form-horizontal">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label class="form-control-label">Chọn ảnh</label>
												<div>
													<input type="file" name="file" required="required"
														id="upload_file" name="file" onchange="preview_image();"
														multiple>
												</div>
											</div>
											<div class="form-actions form-group">
												<button type="submit" class="btn btn-success" name="them">Lưu
													lại</button>
												<button type="submit" class="btn btn-danger" name="huy"
													onclick="history.go(-1);">Hủy bỏ</button>
											</div>
										</div>
										<div class="col-md-7" id="image_preview" width="400px"
											style="display: flex; margin-left: auto; margin-right: auto;"></div>
									</div>

								</form>
							</div>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="datatable-pd" class="display"
									style="width: 100%; color: black;">
									<thead>
										<tr>
											<th>STT</th>
											<th>Hình Ảnh</th>
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

		<!-- Thêm chân trang -->
		<jsp:include page="layout/footer.jsp"></jsp:include>
		<!-- Xong thêm chân trang -->

	</div>
	<script type="text/javascript">
	// dung jquerry datatable ajax lòad data
		var json =
	<%=request.getAttribute("jsonProductsD")%>
		;
		$('#datatable-pd')
				.DataTable(
						{
							data : json,
							columns : [
									{
										data : 'id'
									},
									{
										data : 'imageLink',
										render : function(img) {
											return "<img style='width:100px;' src='viewroot/img/shop/DetailProduct/"+img+"'>";

										}
									},
									{
										data : null,
										render : function(data) {
											var id=data.id;
											var ids=data.idBook;

											return "<button type='button' class='btn btn-sm btn-primary' onclick='deleteBookD("+ id+"," +ids+ ")'>Xóa</button>"
										} },
									],
							"pageLength" : 15
						});
		function deleteBookD(id,ids) {
			var url="AdminBookDetailsController?id="+ids;
			$.ajax({
				url : "AdminDeleteBookDetail?id=" + id,
				type : 'POST',
				success : function(reponse) {
					console.log(reponse);
					alert("Đã xóa thành công ");
					window.location.href=url;
				}

			})
		}
		function preview_image() 
		{
		 var total_file=document.getElementById("upload_file").files.length;
		 for(var i=0;i<total_file;i++)
		 {
		  $('#image_preview').append("<img style='width:25%;' src='"+URL.createObjectURL(event.target.files[i])+"'><br>");
		 }
		}
	</script>

</body>
</html>