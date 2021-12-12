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
							<span class="ml-1">Vận chuyển</span>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Quản trị</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">quản lý vận chuyển</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->


				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Datatable</h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table id="datatable-transport" class="display"
										style="width: 100%;color: black;
    font-size: 13px;">
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
												<th>Trạng thái</th>
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
		<script type="text/javascript">
    	var json=<%=request.getAttribute("jsonTransport")%>;
    	$('#datatable-transport').DataTable({
    	    data: json,
    	    columns: [
    	        { data: 'id' },
    	        { data: 'nameRecevie' },
    	        { data: 'numberHouse' },
    	        { data: 'address' },
    	        { data: 'numberPhone' },
    	        { data: 'email' },
    	        { data: 'note' },
    	        { data: 'datePay' },
    	        { data: 'status',
    	        	render: function(data){
    	        		if(data=="1"){
        	        		return     "<button type='button'  class='btn btn-primary'>Đang vận chuyển</button>"
    	        		}
    	        	}},
    	        	  
    	       { data: 'id',
        	        	render: function(data){
        	        		return     "<button type='button' class='btn btn-sm btn-primary' onclick='payment("+data+")'>Thanh toán</button>"
        	        	}},
        	            { data: 'id',
            	        	render: function(data){
            	        		return     "<button type='button' class='btn btn-sm btn-primary' onclick='closeOrder("+data+")'>Hủy</button>"
            	        	}},
        	        	
    	    ],
    	    "pageLength": 15
    	});
    	function payment(id){
			if(confirm("Đơn hàng đã được thành toán"))
    		$.ajax({
    			url:"AdminTransportController?id="+id,
    			type:'Get',
    			success: function (reponse){
    				console.log(reponse);
    				alert("Đã xóa thành công ");
    				window.location.href="AdminManagaTransportController";
    			}
    		
    		})
    	}
    	function closeOrder(id){
			if(confirm("Bạn muốn hủy vận chuyển đơn hàng"))
    		$.ajax({
    			url:"AdminTransportController?idD="+id,
    			type:'Get',
    			success: function (reponse){
    				console.log(reponse);
    				alert("Đã hủy thành công ");
    				window.location.href="AdminManagaTransportController";			}
    		})
    		
    	}
      
    </script>

	</div>
</body>
</html>