<%@page import="bo.AuthorBO"%>
<%@page import="model.AuthorBook"%>

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
							<span class="ml-1">Sản Phẩm</span>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Quản trị</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">Quản lý sản phẩm</a></li>
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
										class="align-middle"><i class="ti-plus"></i></span> Thêm sản
										phẩm
									</a>
								</div>
								<div class="modal fade none-border" id="add-category">
									<div class="modal-dialog">
										<div class="modal-content" style="width: 1000px;">
											<div class="modal-header">
												<h4 class="modal-title">
													<strong>Thêm Sách</strong>
												</h4>
											</div>
											<div class="modal-body">
									
												<div class="row">
													<div class="col-lg-12">
														<div class="card">
															<div class="card-header">
																<h4 class="card-title">Thông tin sách</h4>
															</div>
															<div class="card-body">
																<div class="form-validation">
																	<form class="form-valide"
																		action="AdminManagaBookController" method="post"
																		enctype="multipart/form-data">
																		<div class="row">
																			<div class="col-xl-6">
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label">Tên
																						Sách <span class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="text" class="form-control"
																							placeholder="Nhập tên sản phẩm" name="username">
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-style">Phong cách<span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="text" class="form-control"
																							id="val-style" placeholder="Nhập phong cách"
																							name="val-style">
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-author">Tên Tác Giả<span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<select class="form-control" id="val-brand"
																							name="val-author">
																							<%
																							ArrayList<AuthorBook> listB = (ArrayList<AuthorBook>) request.getAttribute("listB");
																							for (AuthorBook b : listB) {
																							%>
																							<option value="<%=b.getId()%>"><%=b.getNameAuthor()%></option>
																							<%
																							}
																							%>
																						</select>
																					</div>
																				</div>

																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-address">Địa chỉ sản phẩm<span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="text" class="form-control valid"
																							id="val-address" name="val-address"
																							placeholder="Choose a safe one.."
																							aria-describedby="val-password-error"
																							aria-invalid="false">
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="var-status">Tình trạng<span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="checkbox" id="val-confirm-password"
																							name="var-status" placeholder="..and confirm it!">
																						cũ <input type="checkbox"
																							id="val-confirm-password" name="var-status"
																							placeholder="..and confirm it!"> Mới
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-dependency">Mô Tả <span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<textarea class="form-control"
																							id="val-suggestions" name="val-dependency"
																							rows="5" placeholder="Mô tả sản phẩm"></textarea>
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label">Hình
																						ảnh <span class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="file" id="upload_file" name="file" onchange="preview_image();"
																							class="form-control">
																					</div>
																						<div id="image_preview"></div>
																				</div>
																			</div>
																			<div class="col-xl-6">
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-category">Danh Mục<span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<select class="form-control" id="val-category"
																							name="val-category">
																							<%
																							ArrayList<Category> listC = (ArrayList<Category>) request.getAttribute("listC");
																							for (Category c : listC) {
																							%>
																							<option value="<%=c.getId()%>"><%=c.getNameCategory()%></option>
																							<%
																							}
																							%>
																						</select>
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-currency">Giá tiền<span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="number" class="form-control"
																							id="val-currency" name="val-currency"
																							placeholder="">
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-amount">Số lượng <span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="number" class="form-control"
																							id="val-amount" name="val-amount">
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-discount">Khuyến mãi <span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="number" class="form-control"
																							id="val-discount" name="val-discount"
																							placeholder="212-999-0000">
																					</div>
																				</div>
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"
																						for="val-sdate">Ngày Xuất Bản <span
																						class="text-danger">*</span>
																					</label>
																					<div class="col-lg-6">
																						<input type="date" class="form-control"
																							id="val-digits" name="val-sdate" placeholder="5">
																					</div>
																				</div>
																
																				<div class="form-group row">
																					<label class="col-lg-4 col-form-label"><a>Terms
																							&amp; Conditions</a> <span class="text-danger">*</span>
																					</label>
																					<div class="col-lg-8">
																						<label
																							class="css-control css-control-primary css-checkbox"
																							for="val-terms"> <input type="checkbox"
																							class="css-control-input mr-2" id="val-terms"
																							name="val-terms" value="1"> <span
																							class="css-control-indicator"></span> Bạn đồng ý
																							những thông tin bạn tải lên
																						</label>
																					</div>
																				</div>
																				<div class="form-group row">
																					<div class="col-lg-8 ml-auto">
																						<button type="submit" class="btn btn-primary">Thêm
																							Sách</button>
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

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default waves-effect"
													data-dismiss="modal">Đóng</button>
											</div>
										</div>
									</div>
								</div>

							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table id="datatable-product" style="color: black;font-size:11px"
										class="display" style="min-width: 845px">
										<thead>
											<tr>
												<th>id</th>
												<th>Ten San pham</th>
												<th>Hinh Ảnh</th>
												<th>Mô Ta</th>
												<th>Giá</th>
												<th>Khuyễn mãi</th>
												<th>Tên Tác Giả</th>
												<th>#</th>
												<th>#</th>
												<th>#</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
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
	var list=<%=request.getAttribute("jsonAuthor")%>;
		var json =
	<%=request.getAttribute("jsonProducts")%>;
		;
		$('#datatable-product')
				.DataTable(
						{
							data : json,
							columns : [
									{
										data : 'id'
									},
									{
										data : 'nameBook', width:'30px'
									},
									{
										data : 'imageDisplay',
										render : function(data) {
											return "<img style='width:100px;' src='viewroot/img/shop/product/"+data+"'>";
										}
									},
									{
										data : 'description'
									},
									{
										data : 'priceBook'
									},
									{
										data : 'discount'
									},
									{
										data : 'id_author',
										render:function (data){
											return "<h4>dd</h4>";
										}
										
									},
									{
										data : 'id',
										render : function(data) {
											return "<button type='button' class='btn btn-sm btn-primary' onclick='editProductP("
													+ data
													+ ")'>Chi Tiết</button>"
										}
									},
									{
										data : 'id',
										render : function(data) {
											return "<button type='button' onclick='deleteProduct("
													+ data
													+ ")' class='btn btn-sm btn-primary'>Xóa</button>"
										}
									},
									{
										data : 'id',
										render : function(data) {
											return "<button type='button' class='btn btn-sm btn-primary' onclick='editProduct("
													+ data + ")'>Sửa</button>"
										}
									}, ],
							"pageLength" : 15
						});
		function deleteProduct(id) {
			if(confirm("Bạn muốn xóa sản phẩm này"))
			$.ajax({
				url : "AdminDeleteProducts?id=" + id,
				type : 'POST',
				success : function(reponse) {
					console.log(reponse);
					alert("Đã xóa thành công ");
					window.location.href="AdminManagaBookController";
				}
			})

		}
		
		function editProduct(id) {
			window.location.href = "AdminEditBookController?id=" + id;
		}
		function editProductP(id) {
			window.location.href = "AdminBookDetailsController?id=" + id;
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