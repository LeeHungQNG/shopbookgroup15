<%@page import="model.AuthorBook"%>
<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Books"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="layout/head.jsp"></jsp:include>

</head>
<body>
	<% Books p=(Books) request.getAttribute("bookedit") ;%>
	<div id="main-wrapper">
		<!-- Thêm phần tiêu đề trang -->
		<jsp:include page="layout/header.jsp"></jsp:include>
		<!-- Xong phần tiêu đề trang -->
		<div class="content-body">
			<div class="container-fluid">
				<div class="row page-titles mx-0">
					<div class="col-sm-6 p-md-0">
						<div class="welcome-text">
							<h4>Xin Chào Bạn</h4>
							<p class="mb-1">Sửa sản phẩm</p>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Form</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">Validation</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Thông Tin Sách</h4>
							</div>
							<div class="card-body">
								<div class="form-validation">
									<form class="form-valide" action="AdminEditBookController"
										method="post" enctype="multipart/form-data">
										<div class="row">
											<div class="col-xl-6">
												<div class="form-group row">
													<label class="col-lg-4 col-form-label">Tên sản phẩm
														<span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<input type="text" class="form-control"
															value="<%=p.getNameBook() %>"
															placeholder="Nhấp trên sản phẩm" name="username">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="val-style">Phòng
														cách<span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<input type="text" class="form-control" id="val-style"
															placeholder="Nhập phòng cách" name="val-style"
															value="<%=p.getStyles()%>">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="val-author">Tác
														Giả <span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<select class="form-control" id="val-author"
															name="val-author">
															<%
																							
															ArrayList<AuthorBook> listB = (ArrayList<AuthorBook>) request.getAttribute("listB");
															int id=p.getId_author();
																							for (AuthorBook b : listB) {
																								if(id==b.getId()){
																									
																							%>
															<option value="<%=b.getId()%>" selected="selected"><%=b.getNameAuthor()%></option>
															<%
																							}else {
																							%>
															<option value="<%=b.getId()%>"><%=b.getNameAuthor()%></option>

															<%} }%>
														</select>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="val-address">Địa
														chỉ sản Phẩm<span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<input type="text" class="form-control valid"
															id="val-address" name="val-address"
															placeholder="Choose a safe one.."
															aria-describedby="val-password-error"
															aria-invalid="false" value="<%=p.getStyles()%>">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="var-status">Trình
														trạng<span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<input type="checkbox" id="val-confirm-password"
															name="var-status" placeholder="..and confirm it!">
														cũ <input type="checkbox" id="val-confirm-password"
															name="var-status" placeholder="..and confirm it!">
														Mới
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="val-dependency">Mô
														Tả <span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<textarea class="form-control" id="val-suggestions"
															name="val-dependency" rows="5"
															placeholder="Mô tả sản phẩm"><%=p.getDescription()%></textarea>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label">Hình ảnh <span
														class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<input type="file" id="upload_file" name="file"
															onchange="preview_image();" class="form-control">
													</div>
												</div>
												<div id="image_preview"></div>
											</div>
											<div class="col-xl-6">
												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="val-category">Danh
														Mục<span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<select class="form-control" id="val-category"
															name="val-category">
															<%
															ArrayList<Category> listC = (ArrayList<Category>) request.getAttribute("listC");
															long idc=p.getId_Category();

															for (Category c : listC) {
															if(idc==c.getId()){
																									
															%>
															<option value="<%=c.getId()%>" selected="selected"><%=c.getNameCategory()%></option>
															<%
																}else {
															%>
															<option value="<%=c.getId()%>"><%=c.getNameCategory()%></option>

															<%}} %>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="val-currency">Giá
														tiền<span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<input type="number" class="form-control"
															id="val-currency" name="val-currency" placeholder=""
															value="<%=p.getPriceBook()%>">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="val-amount">Số
														lượng <span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<input type="number" class="form-control" id="val-amount"
															name="val-amount" value="<%=p.getAmount()%>">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label" for="val-discount">Khuyến
														mãi <span class="text-danger">*</span>
													</label>
													<div class="col-lg-6">
														<input type="number" class="form-control"
															id="val-discount" name="val-discount" placeholder=""
															value="<%=p.getDiscount()%>">
													</div>
												</div>
												<div class="form-group row">

													<label class="col-lg-4 col-form-label" for="val-sdate">Ngày
													Xuất Bản Sách
													 <span class="text-danger">*</span>
													</label>
													<% SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
											        String strDate = formatter.format(p.getOutputDate()); %>
													<div class="col-lg-6">
														<input type="date" class="form-control" id="val-digits"
															name="val-sdate" placeholder="5"
															value="<%=strDate%>">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-lg-4 col-form-label"><a>Terms
															&amp; Conditions</a> <span class="text-danger">*</span> </label>
													<div class="col-lg-8">
														<label
															class="css-control css-control-primary css-checkbox"
															for="val-terms"> <input type="checkbox"
															class="css-control-input mr-2" id="val-terms"
															name="val-terms" value="1"> <span
															class="css-control-indicator"></span> Bạn đồng ý những
															thông tin bạn tải lên
														</label>
													</div>
												</div>
												<div class="form-group row">
													<div class="col-lg-8 ml-auto">
														<button type="submit" class="btn btn-primary">Sửa</button>
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
		</div>

		<!-- Thêm chân trang -->
		<jsp:include page="layout/footer.jsp"></jsp:include>
		<!-- Xong thêm chân trang -->

	</div>
	<script type="text/javascript">
	// load ảnh up len va hien thi
		function preview_image() {
			var total_file = document.getElementById("upload_file").files.length;
			for (var i = 0; i < total_file; i++) {
				$('#image_preview').append(
						"<img style='width:25%;' src='"
								+ URL.createObjectURL(event.target.files[i])
								+ "'><br>");
			}
		}
	</script>
</body>
</html>